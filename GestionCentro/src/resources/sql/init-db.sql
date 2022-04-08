DROP TABLE IF EXISTS `Alumno`;
CREATE TABLE `Alumno`
(
<<<<<<< HEAD
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `dni`        varchar(9) NOT NULL,
    `nombre`     varchar(50) NOT NULL,
    `apellidos`  varchar(100) NOT NULL,
    `email`      varchar(100)  NULL,
    `telefono`   varchar(10)  NULL,
    `hasLoseEvaluation` boolean NOT NULL,
    `enabled` boolean not NULL,
    `fechaMatriculacion` Date not NULL,

    PRIMARY KEY (`id`)
) ;

INSERT INTO `Alumno` ( `id`,`dni`,`nombre`,`apellidos`, `email`,`telefono`,`hasLoseEvaluation`,`enabled`,
`fechaMatriculacion`)
VALUES (1,'11111111h','dani','carmona rodriguez', 'dani@alumno.org','611-111111', true, true, date_add(now())),
       (2,'22222222h','jeremy','ramos segura', 'jeremy@alumno.org','622-222222', true, true, now()),
       (3,'33333333h','nuria','gonzalez margallo', 'nuria@alumno.org','633-333333', true, true, now()),
       (4,'44444444h','marta','sanchez perez', 'marta@alumno.org','644-444444', true, true, now()),
       (5,'55555555h','luis','lopez lopez', 'luis@alumno.org','655-555555', true, true, now());
=======
    `id`                 int(11)      NOT NULL AUTO_INCREMENT,
    `dni`                varchar(9)   NOT NULL,
    `nombre`             varchar(50)  NOT NULL,
    `apellidos`          varchar(100) NOT NULL,
    `email`              varchar(100) NULL,
    `telefono`           varchar(10)  NULL,
    `hasLoseEvaluation`  boolean      NOT NULL,
    `enabled`            boolean      not NULL,
    `fechaMatriculacion` Date         not NULL,

    PRIMARY KEY (`id`)
);

INSERT INTO `Alumno` (`id`, `dni`, `nombre`, `apellidos`, `email`, `telefono`, `hasLoseEvaluation`, `enabled`,
                      `fechaMatriculacion`)
VALUES (1, '11111111h', 'dani', 'carmona rodriguez', 'dani@alumno.org', '611-111111', true, true, now()),
       (2, '22222222h', 'jeremy', 'ramos segura', 'jeremy@alumno.org', '622-222222', true, true, now()),
       (3, '33333333h', 'nuria', 'gonzalez margallo', 'nuria@alumno.org', '633-333333', true, true, now()),
       (4, '44444444h', 'marta', 'sanchez perez', 'marta@alumno.org', '644-444444', true, true, now()),
       (5, '55555555h', 'luis', 'lopez lopez', 'luis@alumno.org', '655-555555', true, true, now());
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4



DROP TABLE IF EXISTS `Categoria`;
CREATE TABLE `Categoria`
<<<<<<< HEAD
 (   `nombre` varchar(100) NOT NULL , PRIMARY KEY (nombre)

  ) ;

INSERT INTO `Categoria` (`nombre`)
VALUES ('PRACTICA_03_DAM'),
('EXAMEN_01_DAM'),
('EXPOSICIÓN_06_DAM'),
('EJERCICIO_04_DAM');
=======
(
    `id`     int(11)      NOT NULL AUTO_INCREMENT,
    `nombre` varchar(100) NOT NULL,
    PRIMARY KEY (id)

);

INSERT INTO `Categoria` (`id`, `nombre`)
VALUES (1, 'practica'),
       (2, 'examen'),
       (3, 'exposicion'),
       (4, 'ejercicio');
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4

DROP TABLE IF EXISTS `Calificaciones`;
CREATE TABLE `Calificaciones`
(
<<<<<<< HEAD
    `id` int(100) NOT NULL,
    `idAlumno` int(100) NOT NULL,
    `idPruebaEvaluacion` int(100) NOT NULL,
    `nota` double NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT Fk_PruebaEvaluacion FOREIGN KEY(idPruebaEvaluacion) REFERENCES PruebaEvaluacion(id),
    CONSTRAINT Fk_Alumno FOREIGN KEY(idAlumno) REFERENCES Alumno(id)

) ;

INSERT INTO `Calificaciones` (`id`,`idAlumno` , `idPruebaEvaluacion`, `nota`)
VALUES (1, 1, 1, 8.0);


DROP TABLE IF EXISTS `PruebaEvaluacion`;
CREATE TABLE `PruebaEvaluacion`
(
    `id` int(100) NOT NULL, PRIMARY KEY (`id`),
    `descripcion` varchar(100) NULL,
    `categorias`   varchar(100) NOT NULL,
    `calificaciones` varchar(19)   NOT NULL,
    CONSTRAINT Fk_Categorias FOREIGN KEY(categorias) REFERENCES Categoria(nombre),
    CONSTRAINT Fk_Calificaciones FOREIGN KEY(calificaciones) REFERENCES Categoria(nombre)

) ;

INSERT INTO `PruebaEvaluacion` (`id`, `descripcion`, `categorias`, `calificaciones`)
VALUES (1, 'aaaaaaa', 'PRACTICA_03_DAM', 'Español');
=======
    `id`                 int(100) NOT NULL,
    `idAlumno`           int(100) NOT NULL,
    `idPruebaEvaluacion` int(100) NOT NULL,
    `nota`               double   NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT Fk_Alumno FOREIGN KEY (idAlumno) REFERENCES Alumno (id)

);

INSERT INTO `Calificaciones` (`id`, `idAlumno`, `idPruebaEvaluacion`, `nota`)
VALUES (1, 1, 1, 8.0);


DROP TABLE IF EXISTS PruebaEvaluacion;
CREATE TABLE PruebaEvaluacion
(
    `id`               int(100)     NOT NULL,
    PRIMARY KEY (`id`),
    `descripcion`      varchar(100) NULL,
    `idCategory`       int(100)     NOT NULL,
    `idCalificaciones` int(100)     NOT NULL,
    CONSTRAINT Fk_Categorias FOREIGN KEY (idCategory) REFERENCES Categoria (id),
    CONSTRAINT Fk_Calificaciones FOREIGN KEY (idCalificaciones) REFERENCES Calificaciones (id)

);

INSERT INTO PruebaEvaluacion (`id`, `descripcion`, `idCategory`, `idCalificaciones`)
VALUES (1, 'practica dam', 1, 1);

ALTER TABLE Calificaciones
    ADD CONSTRAINT FOREIGN KEY (idPruebaEvaluacion) REFERENCES PruebaEvaluacion (id);
>>>>>>> 119b189a607e96a40c9768b3b3ff8a74c9f03af4

