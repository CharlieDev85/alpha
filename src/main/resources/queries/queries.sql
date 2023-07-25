SELECT u.user_id, u.first_name, u.last_name, u.email, COUNT(q.quiz_id) AS num_quizzes
FROM users u
         LEFT JOIN quizzes q ON u.user_id = q.user_id
GROUP BY u.user_id, u.first_name, u.last_name, u.email;

