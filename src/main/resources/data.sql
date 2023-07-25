-- Insert initial quizzes
INSERT INTO quizzes (quiz_id, title, instructions, max_score) VALUES (1, 'Middle Test - Basic 1', 'Answer the following questions', 30.0);
INSERT INTO quizzes (quiz_id, title, instructions, max_score) VALUES (2, 'Final Test - Basic 1', 'Answer the following questions', 40.0);

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
INSERT INTO answers (answer_id, text, correct, question_id) VALUES (8, 'buys', false, 3);
INSERT INTO answers (answer_id, text, correct, question_id) VALUES (9, 'bought', true, 3);