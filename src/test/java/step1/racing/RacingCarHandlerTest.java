package step1.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import step1.racing.data.RacingCar;

class RacingCarHandlerTest {

    @Test
    void throw_exception_if_empty_args() {
        assertThatThrownBy(() -> new RacingCarHandler(Collections.EMPTY_LIST, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check_only_winner() {
        RacingCar c1 = new RacingCar("c1", 3);
        RacingCar c2 = new RacingCar("c2", 2);

        RacingCarHandler sut = new RacingCarHandler(Arrays.asList(c1, c2), 1);

        assertThat(sut.getWinners()).contains(c1);
    }

    @Test
    void check_car_position_moved_when_race() {
        RacingCar c1 = new RacingCar("c1", 1);
        RacingCarHandler sut = new RacingCarHandler(Arrays.asList(c1), 1);

        sut.race(() -> true);

        assertThat(c1.getPosition()).isEqualTo(2);
    }
}
