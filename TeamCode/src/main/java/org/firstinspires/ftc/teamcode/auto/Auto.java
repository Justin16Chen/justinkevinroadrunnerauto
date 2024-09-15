package org.firstinspires.ftc.teamcode.auto;

import static com.acmerobotics.roadrunner.ftc.Actions.runBlocking;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.tele.BrainSTEMRobotTele;

public class Auto extends LinearOpMode {

    public static Pose2d beginPose = new Pose2d(0, 0, 0);
    public static Pose2d position1Pose = new Pose2d(50, 20, 0);

    @Override
    public void runOpMode() throws InterruptedException {
        BrainSTEMRobotAuto robot = new BrainSTEMRobotAuto(hardwareMap, telemetry);

        waitForStart();

        robot.drive.pose = beginPose;

        Actions.runBlocking(new SequentialAction(
                robot.lift.raiseLift(),
                robot.lift.lowerLift(),
                robot.drive.actionBuilder(beginPose)
                .splineToSplineHeading(position1Pose)
        ));
    }
}
