package crawler;

import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class TransformDataTest {
    @Spy
    EventDTO eventDTO;

//    @Test
//    public void shouldReturnProperFilter(){
//        List testList = new ArrayList();
//        String test ="Dumb\"Dumb\"Data";
//        testList.add(test);
//        Mockito.when(eventDTO.getRawData()).thenReturn(testList);
//        TransformData.createFormattedArray(eventDTO);
//        assertEquals(eventDTO.getResultOfTransformation().get(0),"Data");
//    }

}