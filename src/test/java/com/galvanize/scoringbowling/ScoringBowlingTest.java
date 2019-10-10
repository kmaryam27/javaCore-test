package com.galvanize.scoringbowling;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoringBowlingTest {
    ScoringBowlingClass scoringBowlingClass;
    Random random = new Random();


    @Before
    public void setUp() throws Exception {
        scoringBowlingClass = new ScoringBowlingClass();
        for (int i = 0; i < 10; i++) {
            scoringBowlingClass.setPinFirst(random.nextInt(5));
            scoringBowlingClass.setPinSecond(random.nextInt(5));
//            scoringBowlingClass.gameList.add(i, scoringBowlingClass.getPinFirst(), scoringBowlingClass.getPinSecond(),scoringBowlingClass.getPinTotal());
        }

    }

    @Test
    public void ScoringBowlingClass_isExist(){
        assertThat(scoringBowlingClass.isExist()).isEqualTo(true);
    }

    @Test
    public void checkFrames_returnsTotalPins(){
        assertThat(scoringBowlingClass.getFrame()).isEqualTo(10);
        int totalpin = 0;
        for (int i = 0; i < scoringBowlingClass.getFrame(); i++) {

           totalpin =  scoringBowlingClass.getPinFirst() + scoringBowlingClass.getPinSecond() ;
        }
        assertThat(scoringBowlingClass.getPinTotal()).isEqualTo(totalpin);
    }
}
