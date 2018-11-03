import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class Examples {
	// Comp1
	// Athlete with position 1
	LinkedList<BiathlonRound> fredRounds = new LinkedList<BiathlonRound>();
	BiathlonRound fredBR1 = new BiathlonRound(0, 10);
	BiathlonRound fredBR2 = new BiathlonRound(5, 15);
	BiathlonRound fredBR3 = new BiathlonRound(3, 20);
	BiathlonRound fredBR4 = new BiathlonRound(2, 10);
	BiathlonRound fredBR5 = new BiathlonRound(1, 15);
	BiathlonResult fredBR = new BiathlonResult(fredRounds);
	CyclingResult fredCR = new CyclingResult(50, 1);
	Athlete fred = new Athlete("Fred", fredBR, fredCR);

	// Athlete with position 2
	LinkedList<BiathlonRound> johnRounds = new LinkedList<BiathlonRound>();
	BiathlonRound johnBR1 = new BiathlonRound(0, 10);
	BiathlonRound johnBR2 = new BiathlonRound(1, 20);
	BiathlonRound johnBR3 = new BiathlonRound(4, 20);
	BiathlonRound johnBR4 = new BiathlonRound(4, 20);
	BiathlonRound johnBR5 = new BiathlonRound(4, 20);
	BiathlonResult johnBR = new BiathlonResult(johnRounds);
	CyclingResult johnCR = new CyclingResult(60, 2);
	Athlete john = new Athlete("John", johnBR, johnCR);

	// Athlete with position 3
	LinkedList<BiathlonRound> sarahRounds = new LinkedList<BiathlonRound>();
	BiathlonRound sarahBR1 = new BiathlonRound(2, 10);
	BiathlonRound sarahBR2 = new BiathlonRound(4, 15);
	BiathlonRound sarahBR3 = new BiathlonRound(3, 7);
	BiathlonRound sarahBR4 = new BiathlonRound(3, 8);
	BiathlonResult sarahBR = new BiathlonResult(sarahRounds);
	CyclingResult sarahCR = new CyclingResult(70, 3);
	Athlete sarah = new Athlete("Sarah", sarahBR, sarahCR);

	// Comp2
	// Athlete with best first round
	LinkedList<BiathlonRound> fred2Rounds = new LinkedList<BiathlonRound>();
	BiathlonRound fred2BR1 = new BiathlonRound(5, 10);
	BiathlonRound fred2BR2 = new BiathlonRound(5, 15);
	BiathlonRound fred2BR3 = new BiathlonRound(3, 20);
	BiathlonRound fred2BR4 = new BiathlonRound(2, 10);
	BiathlonRound fred2BR5 = new BiathlonRound(1, 15);
	BiathlonResult fred2BR = new BiathlonResult(fred2Rounds);
	CyclingResult fred2CR = new CyclingResult(70, 1);
	Athlete fred2 = new Athlete("Fred", fred2BR, fred2CR);

	// Athlete with best middle round
	LinkedList<BiathlonRound> john2Rounds = new LinkedList<BiathlonRound>();
	BiathlonRound john2BR1 = new BiathlonRound(0, 10);
	BiathlonRound john2BR2 = new BiathlonRound(1, 20);
	BiathlonRound john2BR3 = new BiathlonRound(5, 10);
	BiathlonRound john2BR4 = new BiathlonRound(4, 20);
	BiathlonRound john2BR5 = new BiathlonRound(2, 30);
	BiathlonResult john2BR = new BiathlonResult(john2Rounds);
	CyclingResult john2CR = new CyclingResult(60, 2);
	Athlete john2 = new Athlete("John", john2BR, john2CR);

	// Athlete with best last round
	LinkedList<BiathlonRound> sarah2Rounds = new LinkedList<BiathlonRound>();
	BiathlonRound sarah2BR1 = new BiathlonRound(2, 10);
	BiathlonRound sarah2BR2 = new BiathlonRound(4, 15);
	BiathlonRound sarah2BR3 = new BiathlonRound(3, 7);
	BiathlonRound sarah2BR4 = new BiathlonRound(4, 10);
	BiathlonRound sarah2BR5 = new BiathlonRound(5, 10);
	BiathlonResult sarah2BR = new BiathlonResult(sarah2Rounds);
	CyclingResult sarah2CR = new CyclingResult(60, 3);
	Athlete sarah2 = new Athlete("Sarah", sarah2BR, sarah2CR);

	// Comp3
	// fred3
	LinkedList<BiathlonRound> fred3Rounds = new LinkedList<BiathlonRound>();
	BiathlonRound fred3BR1 = new BiathlonRound(5, 10);
	BiathlonResult fred3BR = new BiathlonResult(fred3Rounds);
	CyclingResult fred3CR = new CyclingResult(100, 1);
	Athlete fred3 = new Athlete("Fred", fred3BR, fred3CR);

	// john3
	LinkedList<BiathlonRound> john3Rounds = new LinkedList<BiathlonRound>();
	BiathlonRound john3BR1 = new BiathlonRound(0, 10);
	BiathlonResult john3BR = new BiathlonResult(john3Rounds);
	CyclingResult john3CR = new CyclingResult(110, 2);
	Athlete john3 = new Athlete("John", john3BR, john3CR);

	// sarah3
	LinkedList<BiathlonRound> sarah3Rounds = new LinkedList<BiathlonRound>();
	BiathlonRound sarah3BR1 = new BiathlonRound(2, 10);
	BiathlonResult sarah3BR = new BiathlonResult(sarah3Rounds);
	CyclingResult sarah3CR = new CyclingResult(120, 3);
	Athlete sarah3 = new Athlete("Sarah", sarah3BR, sarah3CR);

	// MarathonResult
	MarathonResult mR1 = new MarathonResult(700, 1);
	MarathonResult mR2 = new MarathonResult(600, 2);

	// Competition1
	LinkedList<Athlete> athletes1 = new LinkedList<Athlete>();
	Competition comp1 = new Competition(athletes1, 5);

	// Competition2
	LinkedList<Athlete> athletes2 = new LinkedList<Athlete>();
	Competition comp2 = new Competition(athletes2, 5);

	// Competition3
	LinkedList<Athlete> athletes3 = new LinkedList<Athlete>();
	Competition comp3 = new Competition(athletes3, 5);

	// Athlete with position 4
	CyclingResult bobCR = new CyclingResult(80, 4);

	public Examples() {
		// fred
		fredRounds.add(fredBR1);
		fredRounds.add(fredBR2);
		fredRounds.add(fredBR3);
		fredRounds.add(fredBR4);
		fredRounds.add(fredBR5);

		// john
		johnRounds.add(johnBR1);
		johnRounds.add(johnBR2);
		johnRounds.add(johnBR3);
		johnRounds.add(johnBR4);
		johnRounds.add(johnBR5);

		// sarah
		sarahRounds.add(sarahBR1);
		sarahRounds.add(sarahBR2);
		sarahRounds.add(sarahBR3);
		sarahRounds.add(sarahBR4);

		// fred2
		fred2Rounds.add(fred2BR1);
		fred2Rounds.add(fred2BR2);
		fred2Rounds.add(fred2BR3);
		fred2Rounds.add(fred2BR4);
		fred2Rounds.add(fred2BR5);

		// john2
		john2Rounds.add(john2BR1);
		john2Rounds.add(john2BR2);
		john2Rounds.add(john2BR3);
		john2Rounds.add(john2BR4);
		john2Rounds.add(john2BR5);

		// sarah2
		sarah2Rounds.add(sarah2BR1);
		sarah2Rounds.add(sarah2BR2);
		sarah2Rounds.add(sarah2BR3);
		sarah2Rounds.add(sarah2BR4);
		sarah2Rounds.add(sarah2BR5);

		// fred3
		fred3Rounds.add(fred3BR1);

		// john3
		john3Rounds.add(john3BR1);

		// sarah3
		sarah2Rounds.add(sarah2BR1);

		// athletes1
		athletes1.add(fred);
		athletes1.add(john);
		athletes1.add(sarah);

		// athletes2
		athletes2.add(fred2);
		athletes2.add(john2);
		athletes2.add(sarah2);

		// athletes3
		athletes3.add(sarah3);
		athletes3.add(fred3);
		athletes3.add(john3);
	}

	// Test Cases


	// BiathlonResult
	// tests for pointsEarned()

	// points of all BiathlonRounds of BiathlonResult: Fred, Comp1
	@Test
	public void testSumBiathlonResult1() {
		assertEquals(fredBR.pointsEarned(), 910, 0.01);
	}

	// points of all BiathlonRounds of BiathlonResult: John, Comp 1
	@Test
	public void testSumBiathlonResult2() {
		assertEquals(johnBR.pointsEarned(), 810, 0.01);
	}

	// points of all BiathlonRounds of BiathlonResult: Sarah, Comp1
	@Test
	public void testSumBiathlonResult3() {
		assertEquals(sarahBR.pointsEarned(), 520, 0.01);
	}

	// tests for bestRound()

	// First round is better than all rounds
	@Test
	public void testBestRoundFirstRound() {
		assertEquals(fred2BR1, fred2BR.bestRound());
	}

	// Middle round is better than all rounds
	@Test
	public void testBestRoundMiddleRound() {
		assertEquals(john2BR3, john2BR.bestRound());
	}

	// Last round is better than all rounds
	@Test
	public void testBestRoundLastRound() {
		assertEquals(sarah2BR5, sarah2BR.bestRound());
	}

	// CyclingResult
	// tests for pointsEarned()

	// points of CyclingResult in 1st position
	@Test
	public void testSumCyclingResultFirstPlace() {
		assertEquals(fredCR.pointsEarned(), 40, 0.01);
	}

	// points of CyclingResult in 2nd position
	@Test
	public void testSumCyclingResultSecondPlace() {
		assertEquals(johnCR.pointsEarned(), 53, 0.01);
	}

	// points of CyclingResult in 3rd position
	@Test
	public void testSumCyclingResultThirdPlace() {
		assertEquals(sarahCR.pointsEarned(), 67, 0.01);
	}

	// points of CyclingResult in position after position 1, 2, and 3
	@Test
	public void testSumCyclingResultAfter() {
		assertEquals(bobCR.pointsEarned(), 80, 0.01);
	}

	// Athlete
	// tests for totalScore()

	// total points of an Athlete: Fred
	@Test
	public void testTotalScore1() {
		assertEquals(fred.totalScore(), 950, 0.01);
	}

	// total points of an Athlete: John
	@Test
	public void testTotalScore2() {
		assertEquals(john.totalScore(), 863, 0.01);
	}

	// total points of an Athlete: Sarah
	@Test
	public void testTotalScore3() {
		assertEquals(sarah.totalScore(), 587, 0.01);
	}

	// Competition
	// tests for BiathlonDNF()

	// all athletes have less rounds than competition rounds
	@Test
	public void testBiathlonDNFAllAthletes() {
		assertEquals(comp3.athletes, comp3.BiathlonDNF());
	}

	// 1 athlete has less rounds than competition rounds
	@Test
	public void testBiathlonDNFSomeAthletes() {
		LinkedList<Athlete> testBiathlonDNF2 = new LinkedList<Athlete>();
		testBiathlonDNF2.add(sarah);
		assertEquals(testBiathlonDNF2, comp1.BiathlonDNF());
	}

	// no athletes have less rounds than competition rounds
	@Test
	public void testBiathlonDNF3NoAthletes() {
		LinkedList<Athlete> testBiathlonDNF3 = new LinkedList<Athlete>();
		assertEquals(testBiathlonDNF3, comp2.BiathlonDNF());
	}

	// tests for scoreForAthlete()

	// athlete whose name exists in list produces athlete's total score
	@Test
	public void testScoreForAthleteFred() {
		assertEquals(comp1.scoreForAthlete("Fred"), 950, .01);
	}

	// athlete whose name exists in list produces athlete's total score
	@Test
	public void testScoreForAthleteJohn() {
		assertEquals(comp1.scoreForAthlete("John"), 863, .01);
	}

	// athlete whose name exists in list produces athlete's total score
	@Test
	public void testScoreForAthleteSarah() {
		assertEquals(comp1.scoreForAthlete("Sarah"), 587, .01);
	}

	// tests for countCyclingImproved()

	// All athletes in this have lower cyclingResults than themselves in
	// otherCompetition
	// Compares mixed lists
	// 3 is different from 1
	@Test
	public void testCountCyclingImprovedAllAthletes() {
		assertEquals(3, comp1.countCyclingImproved(comp3));
	}

	// 1 athlete in this have lower cyclingResults than themselves in
	// otherCompetition
	// one of the athletes has an equal case
	@Test
	public void testCountCyclingImprovedSomeAthletes() {
		assertEquals(1, comp1.countCyclingImproved(comp2));
	}

	// No athletes in this have lower cyclingResults than themselves in
	// otherCompetition
	@Test
	public void testCountCyclingImprovedNoAthletes() {
		assertEquals(0, comp3.countCyclingImproved(comp1));
	}

	// MarathonResult
	// tests for pointsEarned()

	// produces time for marathon which equals its points
	@Test
	public void testSumMarathonResult1() {
		assertEquals(700, mR1.pointsEarned(), .01);
	}

	// produces time for marathon which equal its points
	@Test
	public void testSumMarathonResult2() {
		assertEquals(600, mR2.pointsEarned(), .01);
	}

}
