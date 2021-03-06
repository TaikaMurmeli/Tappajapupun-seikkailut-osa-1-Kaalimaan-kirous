
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kanipeli.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sjsarsa
 */
public class CreatureTest {
    
    private Creature critter;
    private Item item = new HealingItem("kaali", 1, 100, 0);
    /**
     *
     */
    public CreatureTest() {
        
        critter = new Creature(5, "Einari", 10, 1, 1, item);
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
        
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }
    
    /**
     *
     */
    @Test
    public void getters() {
        assertEquals(critter.getBattleTile(), 5);
        assertEquals(critter.getName(), "Einari");
        assertEquals(critter.getMaxHp(), 10); 
        assertEquals(critter.getDamage(), 1);
        assertEquals(critter.getExp(), 1); 
        assertEquals(critter.getBattleTile(), 5);
        assertEquals(critter.getItem(), item);
    }

    /**
     *
     */
    @Test
    public void setDamage() {
        critter.setDamage(3);
        assertEquals(critter.getDamage(), 3);
    }
    
    /**
     *
     */
    @Test
    public void setCurrentHp() {
        critter.setCurrentHp(4);
        assertEquals(critter.getCurrentHp(), 4);
        critter.setCurrentHp(1337);
        assertEquals(critter.getCurrentHp(), 10);
    }
    
    /**
     *
     */
    @Test
    public void setMaxHpToimii() {
        critter.setMaxHp(20);
        assertEquals(critter.getMaxHp(), 20);
    }
    
    /**
     *
     */
    @Test
    public void takesDamage() {
        critter.setMaxHp(10);
        critter.takeDamage(3);  
        assertEquals(critter.getCurrentHp(), 7);
        critter.takeDamage(100);
        assertEquals(critter.getCurrentHp(), 0);
    }
    
    @Test
    public void attack() {
        boolean fail = false;
        for (int i = 0; i < 1000; i++) {
            if (critter.attack() < critter.getDamage()) fail = true;
            if (critter.attack() > critter.getDamage() * 2 - 1) fail = true;
        }
        assertEquals(fail, false);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
