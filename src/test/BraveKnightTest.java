package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.VerificationCollector;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import di.BraveKnight;
import di.Knight;
import di.KnightConfig;
import di.Quest;

//@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=KnightConfig.class)
public class BraveKnightTest {

    @Mock
	Quest mockQuest;
    
    @Rule 
    public MockitoRule mockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS); 
    
    @Autowired
    BraveKnight knight;
	
    @Test
    public void knightShouldNotbeNull() {
    		assertNotNull(knight);
    }
    @Test
    public void kngihtQuestShouldNotbeNull() {
    		assertNotNull(knight.getQuest());
    }
	@Test
	public void knightShouldEmbarkOnSlayDragonQuest() {
		assertEquals(knight.getQuest().questName(),"Slay Dragon");
	}
	//Detect unused stub
	@Test
	public void questNameShouldMockQuest() {
		when(mockQuest.questName()).thenReturn("mock quest");
	}
	
	//Allows mocking interface with default methods
	@Test
	public void questNumberShouldBePositive() {
		BDDMockito.given(mockQuest.questNumber()).willReturn(-2);
		BDDMockito.given(mockQuest.default_questNumber()).willCallRealMethod();
		assertTrue(mockQuest.default_questNumber() > 0);
	}
	
	@Rule
	public VerificationCollector collector = MockitoJUnit.collector();
	//Verification detector

	@Test
	public void verificationCollectorTest() {
		verify(mockQuest).questName();
		verify(mockQuest).questNumber();
	}
	
	@Test
	public void checkSpyBehavior_inherit() {
		List<Integer> list = new ArrayList<Integer>();
	    List<Integer> spyList = Mockito.spy(list);
	 
	    spyList.add(1);
	    spyList.add(2);
	 
	    Mockito.verify(spyList).add(1);
	    Mockito.verify(spyList).add(2);
	 
	    assertEquals(2, spyList.size());
	    	}
	
	@Test
	public void checkSpyBehavior_stub() {
		List<Integer> list = new ArrayList<Integer>();
	    List<Integer> spyList = Mockito.spy(list);
	 
	    spyList.add(1);
	    
	    doReturn(2).when(spyList).get(any(Integer.class));
	    
	    assertEquals(6, spyList.get(0) + spyList.get(3) + spyList.get(2));
	}
	
	//Mock
	@Test
	public void checkMockBehavior() {
		List<Integer> spyList = Mockito.mock(ArrayList.class);
		
		spyList.add(1);
		spyList.add(2);
		
		assertEquals(0, spyList.size());
	}
}










