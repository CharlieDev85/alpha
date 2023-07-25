-- Insert initial users
INSERT INTO users (user_id, email, first_name, last_name) VALUES (1, 'charlesm@mail.com', 'charles', 'marroq' );
INSERT INTO users (user_id, email, first_name, last_name) VALUES (2, 'enriquec@mail.com', 'enrique', 'cabrera' );

-- Insert initial quizzes
INSERT INTO quizzes (quiz_id, title, instructions, max_score, user_id) VALUES (1, 'Middle Test - Basic 1', 'Answer this middle tests', 30.0, 1);
INSERT INTO quizzes (quiz_id, title, instructions, max_score, user_id) VALUES (2, 'Final Test - Basic 1', 'Answer this final test', 40.0, 1);

-- Insert initial questions
INSERT INTO questions (question_id, text, quiz_id) VALUES (1, 'I ___ a developer', 1);
INSERT INTO questions (question_id, text, quiz_id) VALUES (2, 'I ___ a waiter', 1);
INSERT INTO questions (question_id, text, quiz_id) VALUES (3, 'She ____ up at 5am', 2);
INSERT INTO questions (question_id, text, quiz_id) VALUES (4, 'They _____ a computer', 2);

-- Insert initial answers
INSERT INTO answers (answer_id, text, correct, question_id) VALUES (1, 'am', true, 1);
INSERT INTO answers (answer_id, text, correct, question_id) VALUES (2, 'is', false, 1);
INSERT INTO answers (answer_id, text, correct, question_id) VALUES (3, 'are', false, 1);
INSERT INTO answers (answer_id, text, correct, question_id) VALUES (4, 'were', false, 2);
INSERT INTO answers (answer_id, text, correct, question_id) VALUES (5, 'was', true, 2);

INSERT INTO answers (answer_id, text, correct, question_id) VALUES (6, 'wakes', true, 3);
INSERT INTO answers (answer_id, text, correct, question_id) VALUES (7, 'wake', false, 3);
INSERT INTO answers (answer_id, text, correct, question_id) VALUES (8, 'buys', false, 4);
INSERT INTO answers (answer_id, text, correct, question_id) VALUES (9, 'bought', true, 4);

-- git push -u origin main