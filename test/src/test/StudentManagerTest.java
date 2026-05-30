package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
class StudentManagerTest {

    private static StudentManager manager;

    @BeforeAll
    static void setUpBeforeClass() {
        manager = new StudentManager();
    }

    @Test
    @Order(1)
    void testAddStudent() {
        manager.addStudent("Kim");
        assertTrue(manager.hasStudent("Kim"));
    }

    @Test
    @Order(2)
    void testRemoveStudent() {
        manager.removeStudent("Kim");
        assertFalse(manager.hasStudent("Kim"));
    }

    @Test
    @Order(3)
    void testAddDuplicateStudent() {
        manager.addStudent("Lee");

        assertThrows(IllegalArgumentException.class, () -> {
            manager.addStudent("Lee");
        });
    }

    @Test
    @Order(4)
    void testRemoveNonExistingStudent() {
        assertThrows(IllegalArgumentException.class, () -> {
            manager.removeStudent("Park");
        });
    }
}