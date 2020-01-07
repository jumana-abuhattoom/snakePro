package controller;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import model.Question;
import utils.E_Level;

public class importFromJson {

	public void getQuestionFromJson() throws IOException {

		InputStream in = getClass().getResourceAsStream("/questions.json");
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		StringBuilder sb = new StringBuilder();
		String line;

		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		JSONObject json = new JSONObject(sb.toString());
		JSONArray questions = (JSONArray) json.get("questions");
		for (int i = 0; i < questions.length(); ++i) {
			Question qtoadd = importingQuestion(questions, i);
			sysdata.getInstance().questions.add(qtoadd);
		}
	}

	public Question importingQuestion(JSONArray questions, int i) {

		JSONObject rec = questions.getJSONObject(i);
		String question = rec.getString("question");
		int IndexOfCorrectAnswer = rec.getInt("correct_ans");
		int level = rec.getInt("level");
		String team = rec.getString("team");

		JSONArray answers = (JSONArray) rec.get("answers");
		ArrayList<String> s = new ArrayList<>();
		for (int j = 0; j < answers.length(); ++j) {
			s.add(answers.get(j).toString());
		}
		Question q1 = new Question(question, s, IndexOfCorrectAnswer, E_Level.getLevelbyNumber(level));
		return q1;
	}

	
	public static boolean Addquestiontojson(String question, ArrayList<String> answers, int IndexOfCorrectAnswer, int level) {

		if (sysdata.getInstance().AddQuestion(question, answers, IndexOfCorrectAnswer,level)) {
			JSONObject jsonObject1 = new JSONObject();

			// JSON object and values
			JSONArray jsonArray1 = new JSONArray();
			for (Question s : sysdata.getInstance().questions) {
				//System.out.println(s);
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("question", s.getQuestion());
				JSONArray jsonArray = new JSONArray();
				jsonArray.put(s.getAnswers().get(0));
				jsonArray.put(s.getAnswers().get(1));
				jsonArray.put(s.getAnswers().get(2));
				jsonArray.put(s.getAnswers().get(3));
				jsonObject.put("answers", jsonArray);
				jsonObject.put("correct_ans", s.getIndexOfCorrectAnswer());
				jsonObject.put("level", s.getLevel().getLevel());
				jsonObject.put("team", "Rabbit");

				// JSON array and values

				jsonArray1.put(jsonObject);

			}
			jsonObject1.put("questions", jsonArray1);

			// writing the JSONObject into a file(info.json)
			try {
				FileWriter fileWriter = new FileWriter("res/questions.json");
				fileWriter.write(jsonObject1.toString());
				fileWriter.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}

			return true;
		} else {
			return false;
		}
	}

	public static boolean updatequestiontojson(String question, ArrayList<String> answers, int IndexOfCorrectAnswer, int level) {

		if (sysdata.getInstance().UpdateQuestion(question, answers, IndexOfCorrectAnswer,level)) {
			JSONObject jsonObject1 = new JSONObject();
		
			// JSON object and values
			JSONArray jsonArray1 = new JSONArray();
			for (Question s : sysdata.getInstance().questions) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("question", s.getQuestion());
				JSONArray jsonArray = new JSONArray();
				jsonArray.put(s.getAnswers().get(0));
				jsonArray.put(s.getAnswers().get(1));
				jsonArray.put(s.getAnswers().get(2));
				jsonArray.put(s.getAnswers().get(3));
				jsonObject.put("answers", jsonArray);
				jsonObject.put("correct_ans", s.getIndexOfCorrectAnswer());
				jsonObject.put("level", s.getLevel().getLevel());
				jsonObject.put("team", "Rabbit");

				// JSON array and values

				jsonArray1.put(jsonObject);

			}
			jsonObject1.put("questions", jsonArray1);

			// writing the JSONObject into a file(info.json)
			try {
				FileWriter fileWriter = new FileWriter("res/questions.json");
				fileWriter.write(jsonObject1.toString());
				fileWriter.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		} else {
			return false;
		}
	}

	public static boolean reomveQuestiontojson(String q) {

		if (sysdata.getInstance().DeleteQuestion(q)) {
			JSONObject jsonObject1 = new JSONObject();

			// JSON object and values
			JSONArray jsonArray1 = new JSONArray();
			for (Question s : sysdata.getInstance().questions) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("question", s.getQuestion());
				JSONArray jsonArray = new JSONArray();
				jsonArray.put(s.getAnswers().get(0));
				jsonArray.put(s.getAnswers().get(1));
				jsonArray.put(s.getAnswers().get(2));
				jsonArray.put(s.getAnswers().get(3));
				jsonObject.put("answers", jsonArray);
				jsonObject.put("correct_ans", s.getIndexOfCorrectAnswer());
				jsonObject.put("level", s.getLevel().getLevel());
				jsonObject.put("team", "Rabbit");

				// JSON array and values

				jsonArray1.put(jsonObject);

			}
			jsonObject1.put("questions", jsonArray1);

			// writing the JSONObject into a file(info.json)
			try {
				FileWriter fileWriter = new FileWriter("res/questions.json");
				fileWriter.write(jsonObject1.toString());
				fileWriter.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}

			return true;
		} else {
			return false;
		}
	}

}