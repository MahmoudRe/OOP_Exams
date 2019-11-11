import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AudioFileTest {
	
	@Test
	void testAudioFile() {
		AudioFile audio = new AudioFile (15, 20);
		assertEquals("15:20", audio.getLength() );
	}

	@Test
	void testSetLength() {
		AudioFile audio = new AudioFile (17, 10);
		audio.setLength(44, 35);
		assertEquals("44:35", audio.getLength());
	}

	@Test
	void testGetLength() {
		AudioFile audio = new AudioFile (17, 10);
		audio.setLength(44, 35);
		assertFalse(audio.getLength().equals("35:44"));
	}

}
