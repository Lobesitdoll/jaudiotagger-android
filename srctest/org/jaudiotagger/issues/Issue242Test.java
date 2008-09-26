package org.jaudiotagger.issues;

import org.jaudiotagger.AbstractTestCase;
import org.jaudiotagger.tag.mp4.Mp4Tag;
import org.jaudiotagger.tag.TagFieldKey;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.id3.ID3v24Tag;
import org.jaudiotagger.tag.id3.ID3v23Tag;
import org.jaudiotagger.tag.id3.ID3v22Tag;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3File;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * Test Writing to new urls with common interface
 */
public class Issue242Test extends AbstractTestCase
{
    /**
     * Test New Urls ID3v24
     */
    public void testWriteNewUrlsFilev24()
    {
        Exception exceptionCaught = null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("testV1.mp3");

            //Add a v24Tag
            AudioFile af = AudioFileIO.read(testFile);
            MP3File mp3File= (MP3File)af;
            mp3File.setID3v2Tag(new ID3v24Tag());
            mp3File.save();
            mp3File = new MP3File(testFile);

            af = AudioFileIO.read(testFile);
            mp3File= (MP3File)af;
            //Check mapped okay ands empty
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_OFFICIAL_RELEASE_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_OFFICIAL_ARTIST_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_DISCOGS_RELEASE_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_DISCOGS_ARTIST_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_WIKIPEDIA_RELEASE_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_WIKIPEDIA_ARTIST_SITE).size());

            //Now write these fields
            mp3File.getTag().set(mp3File.getTag().createTagField(TagFieldKey.URL_OFFICIAL_RELEASE_SITE,"http://test1"));
            mp3File.getTag().set(mp3File.getTag().createTagField(TagFieldKey.URL_DISCOGS_RELEASE_SITE,"http://test2"));
            mp3File.getTag().set(mp3File.getTag().createTagField(TagFieldKey.URL_DISCOGS_ARTIST_SITE,"http://test3"));
            mp3File.getTag().set(mp3File.getTag().createTagField(TagFieldKey.URL_WIKIPEDIA_RELEASE_SITE,"http://test4"));
            mp3File.getTag().set(mp3File.getTag().createTagField(TagFieldKey.URL_WIKIPEDIA_ARTIST_SITE,"http://test5"));
            mp3File.getTag().set(mp3File.getTag().createTagField(TagFieldKey.URL_OFFICIAL_ARTIST_SITE,"http://test6"));
            mp3File.save();

            af = AudioFileIO.read(testFile);
            mp3File= (MP3File)af;
            //Check mapped okay ands empty
            assertTrue(mp3File.getTag() instanceof ID3v24Tag);
            assertEquals(1,mp3File.getTag().get(TagFieldKey.URL_OFFICIAL_RELEASE_SITE).size());
            assertEquals(1,mp3File.getTag().get(TagFieldKey.URL_DISCOGS_RELEASE_SITE).size());
            assertEquals(1,mp3File.getTag().get(TagFieldKey.URL_DISCOGS_ARTIST_SITE).size());
            assertEquals(1,mp3File.getTag().get(TagFieldKey.URL_WIKIPEDIA_RELEASE_SITE).size());
            assertEquals(1,mp3File.getTag().get(TagFieldKey.URL_WIKIPEDIA_ARTIST_SITE).size());
            assertEquals(1,mp3File.getTag().get(TagFieldKey.URL_OFFICIAL_ARTIST_SITE).size());

            //Delete Fields
            mp3File.getTag().deleteTagField(TagFieldKey.URL_OFFICIAL_RELEASE_SITE); 
            mp3File.getTag().deleteTagField(TagFieldKey.URL_DISCOGS_RELEASE_SITE);
            mp3File.getTag().deleteTagField(TagFieldKey.URL_DISCOGS_ARTIST_SITE);
            mp3File.getTag().deleteTagField(TagFieldKey.URL_WIKIPEDIA_RELEASE_SITE);
            mp3File.getTag().deleteTagField(TagFieldKey.URL_WIKIPEDIA_ARTIST_SITE);
            mp3File.getTag().deleteTagField(TagFieldKey.URL_OFFICIAL_ARTIST_SITE);
            mp3File.save();
            af = AudioFileIO.read(testFile);
            mp3File= (MP3File)af;
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_OFFICIAL_RELEASE_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_OFFICIAL_ARTIST_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_DISCOGS_RELEASE_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_DISCOGS_ARTIST_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_WIKIPEDIA_RELEASE_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_WIKIPEDIA_ARTIST_SITE).size());


        }
        catch (Exception e)
        {
            exceptionCaught = e;
            e.printStackTrace();
        }
        assertNull(exceptionCaught);
    }

     /**
     * Test New Urls ID3v23
     */
    public void testWriteNewUrlsFilev23()
    {
        Exception exceptionCaught = null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("testV1.mp3");

            //Add a v24Tag
            AudioFile af = AudioFileIO.read(testFile);
            MP3File mp3File= (MP3File)af;
            mp3File.setID3v2Tag(new ID3v23Tag());
            mp3File.save();
            mp3File = new MP3File(testFile);

            af = AudioFileIO.read(testFile);
            mp3File= (MP3File)af;
            //Check mapped okay ands empty
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_OFFICIAL_RELEASE_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_OFFICIAL_ARTIST_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_DISCOGS_RELEASE_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_DISCOGS_ARTIST_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_WIKIPEDIA_RELEASE_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_WIKIPEDIA_ARTIST_SITE).size());

            //Now write these fields
            mp3File.getTag().set(mp3File.getTag().createTagField(TagFieldKey.URL_OFFICIAL_RELEASE_SITE,"http://test1"));
            mp3File.getTag().set(mp3File.getTag().createTagField(TagFieldKey.URL_DISCOGS_RELEASE_SITE,"http://test2"));
            mp3File.getTag().set(mp3File.getTag().createTagField(TagFieldKey.URL_DISCOGS_ARTIST_SITE,"http://test3"));
            mp3File.getTag().set(mp3File.getTag().createTagField(TagFieldKey.URL_WIKIPEDIA_RELEASE_SITE,"http://test4"));
            mp3File.getTag().set(mp3File.getTag().createTagField(TagFieldKey.URL_WIKIPEDIA_ARTIST_SITE,"http://test5"));
            mp3File.getTag().set(mp3File.getTag().createTagField(TagFieldKey.URL_OFFICIAL_ARTIST_SITE,"http://test6"));
            mp3File.save();

            af = AudioFileIO.read(testFile);
            mp3File= (MP3File)af;
            //Check mapped okay ands empty
            assertEquals(1,mp3File.getTag().get(TagFieldKey.URL_OFFICIAL_RELEASE_SITE).size());
            assertEquals(1,mp3File.getTag().get(TagFieldKey.URL_DISCOGS_RELEASE_SITE).size());
            assertEquals(1,mp3File.getTag().get(TagFieldKey.URL_DISCOGS_ARTIST_SITE).size());
            assertEquals(1,mp3File.getTag().get(TagFieldKey.URL_WIKIPEDIA_RELEASE_SITE).size());
            assertEquals(1,mp3File.getTag().get(TagFieldKey.URL_WIKIPEDIA_ARTIST_SITE).size());
            assertEquals(1,mp3File.getTag().get(TagFieldKey.URL_OFFICIAL_ARTIST_SITE).size());

            //Delete Fields
            mp3File.getTag().deleteTagField(TagFieldKey.URL_OFFICIAL_RELEASE_SITE);
            mp3File.getTag().deleteTagField(TagFieldKey.URL_DISCOGS_RELEASE_SITE);
            mp3File.getTag().deleteTagField(TagFieldKey.URL_DISCOGS_ARTIST_SITE);
            mp3File.getTag().deleteTagField(TagFieldKey.URL_WIKIPEDIA_RELEASE_SITE);
            mp3File.getTag().deleteTagField(TagFieldKey.URL_WIKIPEDIA_ARTIST_SITE);
            mp3File.getTag().deleteTagField(TagFieldKey.URL_OFFICIAL_ARTIST_SITE);
            mp3File.save();
            af = AudioFileIO.read(testFile);
            mp3File= (MP3File)af;
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_OFFICIAL_RELEASE_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_OFFICIAL_ARTIST_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_DISCOGS_RELEASE_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_DISCOGS_ARTIST_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_WIKIPEDIA_RELEASE_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_WIKIPEDIA_ARTIST_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_OFFICIAL_RELEASE_SITE).size());
        }
        catch (Exception e)
        {
            exceptionCaught = e;
            e.printStackTrace();
        }
        assertNull(exceptionCaught);
    }

     /**
     * Test New Urls ID3v24
     */
    public void testWriteNewUrlsFilev22()
    {
        Exception exceptionCaught = null;
        try
        {
            File testFile = AbstractTestCase.copyAudioToTmp("testV1.mp3");

            //Add a v24Tag
            AudioFile af = AudioFileIO.read(testFile);
            MP3File mp3File= (MP3File)af;
            mp3File.setID3v2Tag(new ID3v22Tag());
            mp3File.save();
            mp3File = new MP3File(testFile);

            af = AudioFileIO.read(testFile);
            mp3File= (MP3File)af;
            //Check mapped okay ands empty
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_OFFICIAL_RELEASE_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_OFFICIAL_ARTIST_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_DISCOGS_RELEASE_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_DISCOGS_ARTIST_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_WIKIPEDIA_RELEASE_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_WIKIPEDIA_ARTIST_SITE).size());

            //Now write these fields
            mp3File.getTag().set(mp3File.getTag().createTagField(TagFieldKey.URL_OFFICIAL_RELEASE_SITE,"http://test1"));
            mp3File.getTag().set(mp3File.getTag().createTagField(TagFieldKey.URL_DISCOGS_RELEASE_SITE,"http://test2"));
            mp3File.getTag().set(mp3File.getTag().createTagField(TagFieldKey.URL_DISCOGS_ARTIST_SITE,"http://test3"));
            mp3File.getTag().set(mp3File.getTag().createTagField(TagFieldKey.URL_WIKIPEDIA_RELEASE_SITE,"http://test4"));
            mp3File.getTag().set(mp3File.getTag().createTagField(TagFieldKey.URL_WIKIPEDIA_ARTIST_SITE,"http://test5"));
            mp3File.getTag().set(mp3File.getTag().createTagField(TagFieldKey.URL_OFFICIAL_ARTIST_SITE,"http://test6"));
            mp3File.save();

            af = AudioFileIO.read(testFile);
            mp3File= (MP3File)af;
            //Check mapped okay ands empty
            assertEquals(1,mp3File.getTag().get(TagFieldKey.URL_OFFICIAL_RELEASE_SITE).size());
            assertEquals(1,mp3File.getTag().get(TagFieldKey.URL_DISCOGS_RELEASE_SITE).size());
            assertEquals(1,mp3File.getTag().get(TagFieldKey.URL_DISCOGS_ARTIST_SITE).size());
            assertEquals(1,mp3File.getTag().get(TagFieldKey.URL_WIKIPEDIA_RELEASE_SITE).size());
            assertEquals(1,mp3File.getTag().get(TagFieldKey.URL_WIKIPEDIA_ARTIST_SITE).size());
            assertEquals(1,mp3File.getTag().get(TagFieldKey.URL_OFFICIAL_ARTIST_SITE).size());

            //Delete Fields
            mp3File.getTag().deleteTagField(TagFieldKey.URL_OFFICIAL_RELEASE_SITE);
            mp3File.getTag().deleteTagField(TagFieldKey.URL_DISCOGS_RELEASE_SITE);
            mp3File.getTag().deleteTagField(TagFieldKey.URL_DISCOGS_ARTIST_SITE);
            mp3File.getTag().deleteTagField(TagFieldKey.URL_WIKIPEDIA_RELEASE_SITE);
            mp3File.getTag().deleteTagField(TagFieldKey.URL_WIKIPEDIA_ARTIST_SITE);
            mp3File.getTag().deleteTagField(TagFieldKey.URL_OFFICIAL_ARTIST_SITE);
            mp3File.save();
            af = AudioFileIO.read(testFile);
            mp3File= (MP3File)af;
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_OFFICIAL_RELEASE_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_OFFICIAL_ARTIST_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_DISCOGS_RELEASE_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_DISCOGS_ARTIST_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_WIKIPEDIA_RELEASE_SITE).size());
            assertEquals(0,mp3File.getTag().get(TagFieldKey.URL_WIKIPEDIA_ARTIST_SITE).size());

        }
        catch (Exception e)
        {
            exceptionCaught = e;
            e.printStackTrace();
        }
        assertNull(exceptionCaught);
    }

}