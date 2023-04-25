CREATE TABLE public.tipo_remision (
    id_tipo_remision SERIAL PRIMARY KEY,
    tipo_remision VARCHAR(255) NOT NULL
);

CREATE TABLE public.primera_escucha (
    id_primera_escucha SERIAL PRIMARY KEY,
    fecha_primera_escucha DATE NOT NULL,
    observacion VARCHAR(255) NOT NULL,
    realizada BOOLEAN NOT NULL
);

CREATE TABLE public.solicitud_remision (
    id_solicitud_remision SERIAL PRIMARY KEY,
    usuario_un_estudiante VARCHAR(255) NOT NULL,
    usuario_un_docente VARCHAR(255) NOT NULL,
    fecha_solicitud_remision DATE NOT NULL,
    justificacion VARCHAR(255) NOT NULL,
    estado BOOLEAN NOT NULL,
    id_tipo_remision INTEGER REFERENCES public.tipo_remision(id_tipo_remision) NOT NULL,
    programa_curricular VARCHAR(255) NOT NULL
);

CREATE TABLE public.remision (
    id_remision SERIAL PRIMARY KEY,
    id_solicitud_remision INTEGER REFERENCES public.solicitud_remision(id_solicitud_remision) NOT NULL,
    id_primera_escucha INTEGER REFERENCES public.primera_escucha(id_primera_escucha) NOT NULL,
    remision_efectiva BOOLEAN NOT NULL,
    fecha_envio_remision DATE NOT NULL
);
