INSERT INTO project_entity (id, description, name, type, url, user_id)
VALUES(2, "Nuclear Power Plant example", "Nuclear Power Plant", null, null, 3);


INSERT INTO loss_entity (id, name, project_id)
VALUES(4, "L-1: Loss of life or injury to people", 2);

INSERT INTO loss_entity (id, name, project_id)
VALUES(5, "L-2: Loss of or damage to vehicle", 2);

INSERT INTO loss_entity (id, name, project_id)
VALUES(6, "L-3: Loss of or damage to objects outside the vehicle", 2);

INSERT INTO loss_entity (id, name, project_id)
VALUES(7, "L-4: Loss of mission (e.g. transportation mission, surveillance mission, scientific mission, defense mission, etc.)", 2);

INSERT INTO loss_entity (id, name, project_id)
VALUES(8, "L-5: Loss of customer satisfaction", 2);

INSERT INTO loss_entity (id, name, project_id)
VALUES(9, "L-6: Loss of sensitive information", 2);

INSERT INTO loss_entity (id, name, project_id)
VALUES(10, "L-7: Environmental loss", 2);

INSERT INTO loss_entity (id, name, project_id)
VALUES(11, "L-8: Loss of power generation", 2);



INSERT INTO system_safety_constraint_entity (id, name)
VALUES(7, "SC-1: Aircraft must satisfy minimum separation standards from other aircraft and objects");

INSERT INTO system_safety_constraint_entity (id, name)
VALUES(8, "SC-2: Aircraft airframe integrity must be maintained under worst-case conditions");

INSERT INTO system_safety_constraint_entity (id, name)
VALUES(9, "SC-6.1: Deceleration must occur within TBD seconds of landing or rejected takeoff at a rate of at least TBD m/s²");

INSERT INTO system_safety_constraint_entity (id, name)
VALUES(10, "SC-6.2: Asymmetric deceleration must not lead to loss of directional control or cause aircraft to depart taxiway, runway, or apron");

INSERT INTO system_safety_constraint_entity (id, name)
VALUES(11, "SC-6.3: Deceleration must not be provided after V1 point during takeoff");



INSERT INTO hazard_entity (id, name, father_id, ssc_id, project_id)
VALUES(7, "H-1: Aircraft violate minimum separation standards in flight", null, 7, 2);

INSERT INTO hazard_entity (id, name, father_id, ssc_id, project_id)
VALUES(8, "H-2: Aircraft airframe integrity is lost", null, 8, 2);

INSERT INTO hazard_entity (id, name, father_id, ssc_id, project_id)
VALUES(9, "H-3: Aircraft leaves designated taxiway, runway, or apron on ground", null, null, 2);

INSERT INTO hazard_entity (id, name, father_id, ssc_id, project_id)
VALUES(10, "H-4: Aircraft comes too close to other objects on the ground", null, null, 2);

INSERT INTO hazard_entity (id, name, father_id, ssc_id, project_id)
VALUES(11, "H-5: Satellite is unable to collect scientific data", null, null, 2);

INSERT INTO hazard_entity (id, name, father_id, ssc_id, project_id)
VALUES(12, "H-6: Vehicle does not maintain safe distance from terrain and other obstacles", null, null, 2);

INSERT INTO hazard_entity (id, name, father_id, ssc_id, project_id)
VALUES(13, "H-7: UAV does not complete surveillance mission", null, null, 2);

INSERT INTO hazard_entity (id, name, father_id, ssc_id, project_id)
VALUES(14, "H-8: Nuclear power plant releases dangerous materials", null, null, 2);


INSERT INTO hazard_entity (id, name, father_id, ssc_id, project_id)
VALUES(15, "H-4.1: Deceleration is insufficient upon landing, rejected takeoff, or during taxiing", 10, 9, 2);

INSERT INTO hazard_entity (id, name, father_id, ssc_id, project_id)
VALUES(16, "H-4.2: Asymmetric deceleration maneuvers aircraft toward other objects", 10, 10, 2);

INSERT INTO hazard_entity (id, name, father_id, ssc_id, project_id)
VALUES(17, "H-4.3: Deceleration occurs after V1 point during takeoff", 10, 11, 2);

INSERT INTO hazard_entity (id, name, father_id, ssc_id, project_id)
VALUES(18, "H-4.4: Excessive acceleration provided while taxiing", 10, null, 2);

INSERT INTO hazard_entity (id, name, father_id, ssc_id, project_id)
VALUES(19, "H-4.5: Asymmetric acceleration maneuvers aircraft toward other objects", 10, null, 2);

INSERT INTO hazard_entity (id, name, father_id, ssc_id, project_id)
VALUES(20, "H-4.6: Acceleration is insufficient during takeoff", 10, null, 2);

INSERT INTO hazard_entity (id, name, father_id, ssc_id, project_id)
VALUES(21, "H-4.7: Acceleration is provided during landing or when parked", 10, null, 2);

INSERT INTO hazard_entity (id, name, father_id, ssc_id, project_id)
VALUES(22, "H-4.8: Acceleration continues to be applied during rejected takeoff", 10, null, 2);

INSERT INTO hazard_entity (id, name, father_id, ssc_id, project_id)
VALUES(23, "H-4.9: Insufficient steering to turn along taxiway, runway, or apron path", 10, null, 2);

INSERT INTO hazard_entity (id, name, father_id, ssc_id, project_id)
VALUES(24, "H-4.10: Steering maneuvers aircraft off the taxiway, runway, or apron path", 10, null, 2);


INSERT INTO hazard_loss (hazard_id, loss_id)
VALUES(7, 4);

INSERT INTO hazard_loss (hazard_id, loss_id)
VALUES(7, 5);

INSERT INTO hazard_loss (hazard_id, loss_id)
VALUES(7, 7);

INSERT INTO hazard_loss (hazard_id, loss_id)
VALUES(7, 8);

INSERT INTO hazard_loss (hazard_id, loss_id)
VALUES(8, 4);

INSERT INTO hazard_loss (hazard_id, loss_id)
VALUES(8, 5);

INSERT INTO hazard_loss (hazard_id, loss_id)
VALUES(8, 7);

INSERT INTO hazard_loss (hazard_id, loss_id)
VALUES(8, 8);

INSERT INTO hazard_loss (hazard_id, loss_id)
VALUES(9, 4);

INSERT INTO hazard_loss (hazard_id, loss_id)
VALUES(9, 5);

INSERT INTO hazard_loss (hazard_id, loss_id)
VALUES(9, 8);

INSERT INTO hazard_loss (hazard_id, loss_id)
VALUES(10, 4);

INSERT INTO hazard_loss (hazard_id, loss_id)
VALUES(10, 5);

INSERT INTO hazard_loss (hazard_id, loss_id)
VALUES(10, 8);

INSERT INTO hazard_loss (hazard_id, loss_id)
VALUES(11, 7);

INSERT INTO hazard_loss (hazard_id, loss_id)
VALUES(12, 4);

INSERT INTO hazard_loss (hazard_id, loss_id)
VALUES(12, 5);

INSERT INTO hazard_loss (hazard_id, loss_id)
VALUES(12, 6);

INSERT INTO hazard_loss (hazard_id, loss_id)
VALUES(12, 7);

INSERT INTO hazard_loss (hazard_id, loss_id)
VALUES(13, 7);

INSERT INTO hazard_loss (hazard_id, loss_id)
VALUES(14, 4);

INSERT INTO hazard_loss (hazard_id, loss_id)
VALUES(14, 7);

INSERT INTO hazard_loss (hazard_id, loss_id)
VALUES(14, 10);

INSERT INTO hazard_loss (hazard_id, loss_id)
VALUES(14, 11);
