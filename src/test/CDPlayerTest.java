package test;

import static org.junit.Assert.*;

import org.gradle.internal.impldep.org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import autowiring.CDPlayerConfig;
import autowiring.CompactDisc;
import autowiring.MediaPlayer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerTest {
	
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Autowired
	private CompactDisc cd;
	
	@Autowired
	private MediaPlayer mp;
	
	@Test
	public void cdShouldNotBeNull() {
		assertNotNull(cd);
	}
	
	@Test
	public void mpShouldNotBeNull(){
		assertNotNull(mp);
	}
	
	@Test
	  public void play() {
	    mp.play();
		    assertEquals(
	        "Playing Sgt. Pepper's Lonely Hearts Club Band" +
	        " by The Beatles\n",
	        systemOutRule.getLog());
	}
}
