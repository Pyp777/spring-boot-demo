package springboot.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = Arrays.asList(new Topic("Spring", "Spring Framework", "Descripted spring"),
			new Topic("Java", "Java Framework", "Descripted java"),
			new Topic(".net", ".net Framework", "Descripted .net"));

	public List<Topic> getAllTopics() {
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for (int i = 0; i < topics.size(); i++) {
			if (topics.get(i).getId().equals(id)) {
				topics.set(i, topic);
				break;
			}
		}
	}

	public void deleteTopic(String id) {
		for (int i = 0; i < topics.size(); i++) {
			if (topics.get(i).getId().equals(id)) {
				topics.remove(i);
				break;
			}
		}
	}
}
