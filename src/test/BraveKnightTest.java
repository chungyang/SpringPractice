package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.VerificationCollector;

import di.BraveKnight;
import di.Quest;

@RunWith(MockitoJUnitRunner.class)
public class BraveKnightTest {

    
    @Mock
	Quest mockQuest;
    
	@Test
	public void knightShouldEmbarkOnQuest() {
		
		BraveKnight knight = new BraveKnight(mockQuest);
		knight.embarkOnQuest();
		verify(mockQuest, times(1)).embark();
	} 
	
	//Detect unused stub
	@Test
	public void questNameShouldMockQuest() {
		when(mockQuest.questName()).thenReturn("mock quest");
		assertEquals(5,5);
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

	public void verificationCollectorTest() {
		
	}
}










