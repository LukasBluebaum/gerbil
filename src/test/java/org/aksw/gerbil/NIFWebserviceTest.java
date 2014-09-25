package org.aksw.gerbil;

import it.acubelab.batframework.utils.WikipediaApiInterface;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.aksw.gerbil.annotators.NIFWebserviceAnnotatorConfiguration;
import org.aksw.gerbil.database.SimpleLoggingDAO4Debugging;
import org.aksw.gerbil.datasets.ACE2004DatasetConfig;
import org.aksw.gerbil.datatypes.ExperimentTaskConfiguration;
import org.aksw.gerbil.datatypes.ExperimentType;
import org.aksw.gerbil.matching.Matching;

public class NIFWebserviceTest {

    private static final String ANNOTATOR_URL = "http://localhost:8080/gerbil-spotWrapNifWS4Test/spotlight";
    private static final String ANNOTATOR_NAME = "gerbil-spotWrapNifWS4Test";

    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
        WikipediaApiInterface wikiAPI = new WikipediaApiInterface("wiki-id-title.cache", "wiki-id-id.cache");
        ExperimentTaskConfiguration taskConfigs[] = new ExperimentTaskConfiguration[] { new
                ExperimentTaskConfiguration(
                        new NIFWebserviceAnnotatorConfiguration(ANNOTATOR_URL, ANNOTATOR_NAME, false,
                                ExperimentType.D2W),
                        new ACE2004DatasetConfig(wikiAPI), ExperimentType.D2W,
                        Matching.STRONG_ANNOTATION_MATCH) };
        Experimenter experimenter = new Experimenter(wikiAPI, new SimpleLoggingDAO4Debugging(), taskConfigs,
                "SPOTLIGHT_TEST");
        experimenter.run();
    }
}
