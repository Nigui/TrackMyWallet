package fr.nigui.trackmywallet;

import org.junit.Test;

import fr.nigui.trackmywallet.data.model.FiatCurrency;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class FiatCurrencyTest {

    @Test
    public void fromString() throws Exception {

        assertEquals(FiatCurrency.fromString("EUR"),FiatCurrency.EUR);
        assertEquals(FiatCurrency.fromString("HUF"),FiatCurrency.HUF);
        assertEquals(FiatCurrency.fromString("GBP"),FiatCurrency.GBP);

    }

    @Test(expected = IllegalArgumentException.class)
    public void fromStringFail() throws Exception{

        assertNull(FiatCurrency.fromString("ZZZ"));
        assertNull(FiatCurrency.fromString(""));
        assertNull(FiatCurrency.fromString(" "));
        assertNull(FiatCurrency.fromString(null));

    }

}