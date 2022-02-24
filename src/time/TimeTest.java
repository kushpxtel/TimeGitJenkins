package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {
	@Test
	void testGetMillisecondsGood() {
		int milliseconds = Time.getMilliseconds("10:59:59:005");
		assertTrue("The milliseconds were not calculated properly", milliseconds==5);
	}
	
	
	@Test
	void testGetTotalMilliSecondsBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class,
				() -> {Time.getMilliseconds("10:00");
			}
		);	
	}
	
	
	@Test
	void testGetMilliSecondsBoundary() {
		int milliseconds = Time.getMilliseconds("03:59:59:999");
		assertTrue("",milliseconds==999);
	}
	
	

	@Test
	void testGetTotalSecondsGood() {
		int seconds = Time.getTotalSeconds("05:05:05:000");
		assertTrue("The seconds were not calculated properly", seconds==18305);
		
	}
	
	@Test
	void testGetTotalSecondsBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class,
				() -> {Time.getTotalSeconds("10:00");
			}
		);	
	}
	
	void testGetTotalSecondsBoundary() {
		int seconds = Time.getTotalSeconds("03:59:59");
		assertTrue("",seconds==14399);
	}
	
	
	@ParameterizedTest
	@ValueSource( strings = {"02:20:00","02:20:59"})
	void testGetTotalMinutesBoundaryAndGood(String abc) {
		int minutes = Time.getTotalMinutes(abc);
		assertTrue("The minutes were not calculated properly", minutes==20 );
	}
	
	@Test
	void testGetTotalMinutesBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class,
				() -> {Time.getTotalMinutes("06");
				}
				);
		}
	
	
	@Test
	void testGetTotalHoursGood() {
		int hours = Time.getTotalHours("05:05:05");
		assertTrue("The seconds were not calculated properly", hours==5);
	} 
	
	@ParameterizedTest
	@ValueSource( strings = {"02:20:00","02:20:59"})
	void testGetTotalHoursBoundaryAndGood(String abc) {
		int hours = Time.getTotalHours(abc);
		assertTrue("The hours were not calculated properly", hours==02 );
	}
	
	@Test
	void testGetTotalHoursBad() {
		assertThrows(
				NumberFormatException.class,
				() -> {Time.getTotalHours("bhau");
				}
				);
		}
	
	
	
	}
	

