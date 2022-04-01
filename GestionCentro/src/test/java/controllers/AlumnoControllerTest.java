package controllers;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import repositories.AlumnoRepository;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoControllerTest {
    @Mock
    private AlumnoRepository repository = new AlumnoRepository();

    @InjectMocks
    private AlumnoController controller = AlumnoController.getInstance(new AlumnoRepository());

}