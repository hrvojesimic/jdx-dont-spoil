package jdx.dontspoil.repository;

import jdx.dontspoil.domain.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, Integer> {

}
