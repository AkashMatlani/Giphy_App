package akash.com.giphyapp.utills.rx;

import io.reactivex.Scheduler;

public interface SchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();
}
