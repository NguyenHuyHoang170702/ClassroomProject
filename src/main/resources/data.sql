INSERT INTO users (username, name, email, password, status)
VALUES ('admin', 'John Doe', 'john@example.com', '$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu', true),
       ('ramesh', 'Jane Smith', 'jane@example.com', '$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em', true),
       ('mike_wilson', 'Mike Wilson', 'mike@example.com', 'pass456', true);


INSERT INTO roles (rolename, description)
VALUES ('ROLE_ADMIN', 'Administrator role with full access'),
       ('ROLE_STUDENT', 'Regular user role with basic access'),
       ('ROLE_TEACHER', 'Teacher role with special access');

INSERT INTO classrooms (name_class, description_class, code_class)
VALUES ('Mathematics', 'Classroom for mathematics course.', 'MATH101'),
       ('History', 'Classroom for history course.', 'HIST202'),
       ('Science', 'Classroom for science course.', 'SCI303');


INSERT INTO news (title, content, timestamp, class_id)
VALUES ('Important Announcement', 'Lorem ipsum dolor sit amet.', '2024-03-18 08:00:00', 1),
       ('Upcoming Event', 'Consectetur adipiscing elit.', '2024-03-19 10:00:00', 2),
       ('Classroom Updates', 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '2024-03-20 12:00:00', 3);


INSERT INTO comments (content, timestamp, username, news_id)
VALUES ('Great news! Looking forward to it.', '2024-03-18 08:30:00', 'ramesh', 1),
       ('Can we discuss this further in class?', '2024-03-20 10:30:00', 'mike_wilson', 3);


INSERT INTO homeworks (class_id, name, description, size, score, homework_code, content)
VALUES (1, 'Assignment 1', 'Complete the assigned tasks.', 1024, 80, 'HW001', null),
       (2, 'Project Submission', 'Submit your project by the deadline.', 2048, 90, 'HW002', null),
       (3, 'Research Paper', 'Write a research paper on the given topic.', 4096, 85, 'HW003', null);

INSERT INTO user_role (user_id, role_id)
VALUES (1, 1),  -- Assigning ROLE_ADMIN to user john_doe
       (2, 2), -- Assigning ROLE_USER to user jane_smith
       (3, 3); -- Assigning ROLE_TEACHER to user mike_wilson

INSERT INTO user_classroom (user_id, classroom_id)
VALUES (2, 1),  -- Assigning classroom Mathematics to user john_doe
       (3, 3); -- Assigning classroom Science to user mike_wilson


INSERT INTO news_user (news_id, user_id)
VALUES (1, 2),  -- Assigning news ID 1 to user john_doe
       (3,3); -- Assigning news ID 3 to user mike_wilson

INSERT INTO user_homework (user_id, homework_id)
VALUES (2, 1),  -- Assigning homework ID 1 to user john_doe
       (3, 3); -- Assigning homework ID 3 to user mike_wilson
