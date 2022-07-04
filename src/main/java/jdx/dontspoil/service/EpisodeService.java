package jdx.dontspoil.service;

import jdx.dontspoil.domain.Episode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EpisodeService {
    private static List<String> EPISODES = List.of(
        "The Vanishing of Will Byers", "The Weirdo on Maple Street",
        "Holly, Jolly", "The Body", "The Flea and the Acrobat",
        "The Monster", "The Bathtub", "The Upside Down"
    );

    public List<Episode> getAllEpisodes() {
        List<Episode> result = new ArrayList<>();
        for (int i = 0; i < EPISODES.size(); i++) {
            String title = EPISODES.get(i);
            Episode episode = new Episode();
            episode.setOrderingNumber(i + 1);
            episode.setTitle(title);
            result.add(episode);
        }
        return result;
    }
}
