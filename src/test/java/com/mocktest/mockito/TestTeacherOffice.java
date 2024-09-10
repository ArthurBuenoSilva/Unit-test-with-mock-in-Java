package com.mocktest.mockito;

import com.google.gson.JsonSyntaxException;
import com.mocktest.TeacherConst;
import com.mocktest.TeacherOfficeHoursController;
import com.mocktest.TeacherOfficeHoursModel;
import com.mocktest.TeacherOfficeHoursService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TestTeacherOffice {
	@Mock
	private TeacherOfficeHoursService service;

	private TeacherOfficeHoursController controller;

	@Before
	public void setUp() {
		controller = new TeacherOfficeHoursController(service);
	}

	@Test
	public void testGetTeacherOfficeHoursInfo() {
		String teachers = TeacherConst.concatIntoJsonArray(TeacherConst.TEACHER_1);
		Mockito.when(service.fetchData()).thenReturn(teachers);

		TeacherOfficeHoursModel teacher = controller.getTeacherOfficeHoursInfo("John Doe");
		assertNotNull(teacher);
		assertEquals(teacher.name, "John Doe");
		assertEquals(teacher.room, 1);
		assertEquals(teacher.officeHour, "10:00 AM - 11:00 AM");
	}

	@Test
	public void testGetTeacherOfficeHoursInfoWhenTheresMoreThanOne() {
		String teachers = TeacherConst.concatIntoJsonArray(TeacherConst.TEACHER_1, TeacherConst.TEACHER_2);
		Mockito.when(service.fetchData()).thenReturn(teachers);

		TeacherOfficeHoursModel teacher = controller.getTeacherOfficeHoursInfo("John Doe");
		assertNotNull(teacher);
		assertEquals(teacher.name, "John Doe");
		assertEquals(teacher.room, 1);
		assertEquals(teacher.officeHour, "10:00 AM - 11:00 AM");
	}

	@Test
	public void testGetWrongTeacherOfficeHoursInfo() {
		String teachers = TeacherConst.concatIntoJsonArray(TeacherConst.TEACHER_3, TeacherConst.TEACHER_4);
		Mockito.when(service.fetchData()).thenReturn(teachers);

		TeacherOfficeHoursModel teacher = controller.getTeacherOfficeHoursInfo("John Doe");
		assertNull(teacher);
	}

	@Test(expected = JsonSyntaxException.class)
	public void testFetchDataOfSingleJSONObject() {
		Mockito.when(service.fetchData()).thenReturn(TeacherConst.TEACHER_1);
		controller.getTeacherOfficeHoursInfo("John Doe");
	}

	@Test
	public void testIsTeacherExists() {
		String teachers = TeacherConst.concatIntoJsonArray(TeacherConst.TEACHER_5, TeacherConst.TEACHER_6);
		Mockito.when(service.fetchData()).thenReturn(teachers);

		boolean isTeacherExists = controller.isTeacherExists("Diana Evans");
		assertTrue(isTeacherExists);
	}

	@Test
	public void testIsTeacherDontExists() {
		String teachers = TeacherConst.concatIntoJsonArray(TeacherConst.TEACHER_5, TeacherConst.TEACHER_6);
		Mockito.when(service.fetchData()).thenReturn(teachers);

		boolean isTeacherExists = controller.isTeacherExists("Bob Brown");
		assertFalse(isTeacherExists);
	}

	@Test
	public void testIsTeacherAvailable() {
		String teachers = TeacherConst.concatIntoJsonArray(TeacherConst.TEACHER_6, TeacherConst.TEACHER_7);
		Mockito.when(service.fetchData()).thenReturn(teachers);

		boolean isTeacherAvailable = controller.isTeacherAvailable("Evan Foster", "10:00 AM - 11:00 AM");
		assertTrue(isTeacherAvailable);
	}

	@Test
	public void testIsTeacherNotAvailable() {
		String teachers = TeacherConst.concatIntoJsonArray(TeacherConst.TEACHER_7, TeacherConst.TEACHER_8);
		Mockito.when(service.fetchData()).thenReturn(teachers);

		boolean isTeacherAvailable = controller.isTeacherAvailable("Evan Foster", "11:00 AM - 12:00 AM");
		assertFalse(isTeacherAvailable);
	}

	@Test
	public void testIsTeacherAvailableDontExists() {
		String teachers = TeacherConst.concatIntoJsonArray(TeacherConst.TEACHER_9, TeacherConst.TEACHER_10);
		Mockito.when(service.fetchData()).thenReturn(teachers);

		boolean isTeacherAvailable = controller.isTeacherAvailable("Evan Foster", "11:00 AM - 12:00 AM");
		assertFalse(isTeacherAvailable);
	}

	@Test
	public void testGetTeacherRoomNumber() {
		String teachers = TeacherConst.concatIntoJsonArray(TeacherConst.TEACHER_9, TeacherConst.TEACHER_10);
		Mockito.when(service.fetchData()).thenReturn(teachers);

		int roomNumber = controller.getTeacherRoomNumber("Hannah White");
		assertEquals(roomNumber, 10);
	}

	@Test
	public void testGetWrongTeacherRoomNumber() {
		String teachers = TeacherConst.concatIntoJsonArray(TeacherConst.TEACHER_9, TeacherConst.TEACHER_10);
		Mockito.when(service.fetchData()).thenReturn(teachers);

		int roomNumber = controller.getTeacherRoomNumber("John Doe");
		assertEquals(roomNumber, 0);
	}

	@Test
	public void testGetTeacherBuildingNumber() {
		String teachers = TeacherConst.concatIntoJsonArray(TeacherConst.TEACHER_1, TeacherConst.TEACHER_2);
		Mockito.when(service.fetchData()).thenReturn(teachers);

		int buildingNumber = controller.getTeacherBuildingNumber("John Doe");
		assertEquals(buildingNumber, 1);
	}

	@Test
	public void testGetTeacherBuildingNumberInvalidRoom() {
		String teachers = TeacherConst.concatIntoJsonArray(TeacherConst.TEACHER_3, TeacherConst.TEACHER_4);
		Mockito.when(service.fetchData()).thenReturn(teachers);

		int buildingNumber;

		buildingNumber = controller.getTeacherBuildingNumber("Alice Johnson");
		assertEquals(buildingNumber, 3);

		buildingNumber = controller.getTeacherBuildingNumber("Bob Brown");
		assertEquals(buildingNumber, 4);
	}

	@Test
	public void testGetTeacherOfficeHoursInfoNullData() {
		Mockito.when(service.fetchData()).thenReturn(null);

		TeacherOfficeHoursModel teacher = controller.getTeacherOfficeHoursInfo("John Doe");
		assertNull(teacher);
	}

	@Test
	public void testIsTeacherAvailableNullData() {
		Mockito.when(service.fetchData()).thenReturn(null);

		boolean isTeacherAvailable = controller.isTeacherAvailable("John Doe", "10:00 AM - 11:00 AM");
		assertFalse(isTeacherAvailable);
	}

	@Test
	public void testIsTeacherExistsNullData() {
		Mockito.when(service.fetchData()).thenReturn(null);

		boolean isTeacherExists = controller.isTeacherExists("John Doe");
		assertFalse(isTeacherExists);
	}

	@Test
	public void testGetTeacherRoomNumberNullData() {
		Mockito.when(service.fetchData()).thenReturn(null);

		int roomNumber = controller.getTeacherRoomNumber("John Doe");
		assertEquals(roomNumber, 0);
	}

	@Test
	public void testGetTeacherOfficeHoursInfoInvalidJson() {
		Mockito.when(service.fetchData()).thenReturn(null);

		TeacherOfficeHoursModel teacher = controller.getTeacherOfficeHoursInfo("John Doe");
		assertNull(teacher);
	}

	@Test
	public void testMultipleTeachersWithOverlappingOfficeHours() {
		String teachers = TeacherConst.concatIntoJsonArray(
				TeacherConst.TEACHER_1, // John Doe: 10:00 AM - 11:00 AM
				TeacherConst.TEACHER_2, // Jane Smith: 11:00 AM - 12:00 PM
				TeacherConst.TEACHER_8, // Fiona Green: 11:00 AM - 12:00 PM
				TeacherConst.TEACHER_9 // George Harris: 1:00 PM - 2:00 PM
		);
		Mockito.when(service.fetchData()).thenReturn(teachers);

		boolean isJaneAvailable = controller.isTeacherAvailable("Jane Smith", "11:00 AM - 12:00 PM");
		boolean isFionaAvailable = controller.isTeacherAvailable("Fiona Green", "11:00 AM - 12:00 PM");

		assertTrue(isJaneAvailable);
		assertTrue(isFionaAvailable);
	}

	@Test
	public void testFetchingTeacherInfoWithInvalidAndValidJson() {
		// First, return invalid JSON
		Mockito.when(service.fetchData()).thenReturn(null);
		TeacherOfficeHoursModel teacher = controller.getTeacherOfficeHoursInfo("John Doe");
		assertNull(teacher);

		// Then, return valid JSON
		String teachers = TeacherConst.concatIntoJsonArray(TeacherConst.TEACHER_1);
		Mockito.when(service.fetchData()).thenReturn(teachers);
		teacher = controller.getTeacherOfficeHoursInfo("John Doe");
		assertNotNull(teacher);
		assertEquals(teacher.name, "John Doe");
		assertEquals(teacher.room, 1);
		assertEquals(teacher.officeHour, "10:00 AM - 11:00 AM");
	}
}
