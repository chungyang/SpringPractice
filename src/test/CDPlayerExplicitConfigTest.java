package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.gradle.internal.impldep.org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import autowiring.CDPlayerExplicitConfig;
import autowiring.CompactDisc;
import autowiring.DVDPlayer;
import autowiring.MediaPlayer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerExplicitConfig.class)
public class CDPlayerExplicitConfigTest {
	
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Autowired
	private CompactDisc cd;
	
	@Autowired
	private MediaPlayer mp;
	
	@Autowired
	@Qualifier("dvd")
	private DVDPlayer dp;
	
	@Test
	public void cdShouldNotBeNull() {
		assertNotNull(cd);
	}
	
	@Test
	public void mpShouldNotBeNull(){
		assertNotNull(mp);
	}
	
	@Test
	public void dpShouldNotBeNull(){
		assertNotNull(dp);
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
