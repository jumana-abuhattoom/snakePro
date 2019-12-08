package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

import org.json.JSONArray;
import org.json.JSONObject;

import jdk.nashorn.internal.parser.JSONParser;
import model.Question;
import utils.E_Level;

public class importFromJson {
	
	/// -------------------------------- JUMANA: 
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
			Question qtoadd = importingQuestion(questions , i ); 
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

	
	
	
	
	
	public boolean Addquestiontojson(Question q) {
		sysdata.getInstance().questions.add(q);
		JSONObject jsonObject1 = new JSONObject();

		// JSON object and values
		JSONArray jsonArray1 = new JSONArray();
		for (Question s : sysdata.getInstance().questions) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("question", s.questionNumber);
			JSONArray jsonArray = new JSONArray();
			jsonArray.put(s.answers.get(0));
			jsonArray.put(s.answers.get(1));
			jsonArray.put(s.answers.get(2));
			jsonArray.put(s.answers.get(3));
			jsonObject.put("answers", jsonArray);
			jsonObject.put("correct_ans", s.IndexOfCorrectAnswer);
			jsonObject.put("level", s.level);
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
		System.out.println(jsonObject1);
		return true;
	}

	
	
	

}

