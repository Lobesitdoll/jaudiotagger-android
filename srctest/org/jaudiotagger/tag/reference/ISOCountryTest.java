package org.jaudiotagger.tag.reference;

import org.jaudiotagger.AbstractTestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Testing of ISCountries
 */
public class ISOCountryTest extends AbstractTestCase
{
    /**
     * This tests lower case genre names identifications
     */
    @Test
    public void testCountryMatches()
    {
        //Find by Code
        assertEquals(ISOCountry.Country.UNITED_KINGDOM, ISOCountry.getCountryByCode("GB"));

        //Find by Description - case senstive
        assertEquals(ISOCountry.Country.UNITED_KINGDOM, ISOCountry.getCountryByDescription("United Kingdom"));
        assertNull(ISOCountry.getCountryByDescription("united kingdom"));

        //Doesnt exist
        assertNull(ISOCountry.getCountryByCode("GBE"));
        assertNull(ISOCountry.getCountryByDescription("england"));

        //All values can be found
        for (ISOCountry.Country country : ISOCountry.Country.values())
        {
            assertNotNull(ISOCountry.getCountryByCode(country.getCode()));
            assertNotNull(ISOCountry.getCountryByDescription(country.getDescription()));
        }
    }
}
