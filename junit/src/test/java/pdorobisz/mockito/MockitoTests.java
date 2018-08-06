package pdorobisz.mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 * http://docs.mockito.googlecode.com/hg/latest/org/mockito/Mockito.html
 * 
 */
public class MockitoTests {

    @SuppressWarnings("unchecked")
    @Test
    public void testMock() {
        List<String> mockedList = mock(List.class);
        when(mockedList.size()).thenReturn(100);

        mockedList.add("once");
        mockedList.add("twice");
        mockedList.add("twice");

        System.out.println(mockedList.size());
        verify(mockedList).add("once");
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, never()).clear();
        verify(mockedList).size();
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testAnswer() {
        List<String> mockedList = mock(List.class);
        when(mockedList.get(Mockito.anyInt())).thenAnswer(new Answer<String>() {

            @Override
            public String answer(InvocationOnMock invocation) throws Throwable {
                Object[] arguments = invocation.getArguments();
                System.out.print("called with: ");
                for (Object argument : arguments) {
                    System.out.print(argument + ", ");
                }
                System.out.println();
                return arguments[0].toString();
            }
        });

        System.out.println("for 1 - got: " + mockedList.get(1));
        System.out.println("for 9 - got: " + mockedList.get(9));
    }
}
