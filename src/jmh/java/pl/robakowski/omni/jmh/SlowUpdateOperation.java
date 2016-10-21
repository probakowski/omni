package pl.robakowski.omni.jmh;

import pl.robakowski.omni.Operation;

import java.time.Instant;
import java.util.List;

public class SlowUpdateOperation implements Operation<List<Person>, Integer>
{
    @Override
    public Integer perform( List<Person> root, Instant now )
    {
        Person person = root.get( 0 );
        person.setAge( person.getAge() + 1 );
        try
        {
            Thread.sleep( 10 );
        }
        catch( InterruptedException e )
        {
            throw new IllegalStateException( e );
        }
        return person.getAge();
    }
}
