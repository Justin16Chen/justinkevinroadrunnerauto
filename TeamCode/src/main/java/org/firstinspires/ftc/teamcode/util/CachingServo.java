import com.qualcomm.robotcore.hardware.ServoControllerEx;
import com.qualcomm.robotcore.hardware.ServoImplEx;
import com.qualcomm.robotcore.hardware.PwmControl;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.ServoConfigurationType;

public class CachingServo extends ServoImplEx {

    private double lastPosition = 0;

    public CachingServo(ServoImplEx servo, double min, double max) {
        super((ServoControllerEx) servo.getController(), servo.getPortNumber(), ServoConfigurationType.getStandardServoType());
        this.setPwmRange(new PwmControl.setPwmRange(min, max));
    }

    @Override
    public synchronized void setPosition(double position) {
        if (position != lastPosition) {
            super.setPosition(position);
            lastPosition = position;
        }
    }

}