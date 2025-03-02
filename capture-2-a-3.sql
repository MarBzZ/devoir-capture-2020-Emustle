--
-- PostgreSQL database dump
--

-- Dumped from database version 12.4
-- Dumped by pg_dump version 12.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: capture; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE capture WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'French_Canada.1252' LC_CTYPE = 'French_Canada.1252';


ALTER DATABASE capture OWNER TO postgres;

\connect capture

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: precipitation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.precipitation (
    id integer NOT NULL,
    moment timestamp without time zone,
    mesure double precision
);


ALTER TABLE public.precipitation OWNER TO postgres;

--
-- Name: precipitation_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.precipitation_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.precipitation_id_seq OWNER TO postgres;

--
-- Name: precipitation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.precipitation_id_seq OWNED BY public.precipitation.id;


--
-- Name: precipitation id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.precipitation ALTER COLUMN id SET DEFAULT nextval('public.precipitation_id_seq'::regclass);


--
-- Data for Name: precipitation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.precipitation VALUES (1, '2019-09-02 13:00:00', 25.1);
INSERT INTO public.precipitation VALUES (2, '2019-09-02 14:00:00', 20.5);
INSERT INTO public.precipitation VALUES (3, '2019-09-02 15:00:00', 6.1);
INSERT INTO public.precipitation VALUES (4, '2019-09-23 16:00:00', 0.2);
INSERT INTO public.precipitation VALUES (5, '2019-09-23 17:00:00', 0.3);
INSERT INTO public.precipitation VALUES (6, '2019-09-23 18:00:00', 0.1);
INSERT INTO public.precipitation VALUES (7, '2019-10-02 13:00:00', 0.1);
INSERT INTO public.precipitation VALUES (8, '2019-10-02 14:00:00', 0.3);
INSERT INTO public.precipitation VALUES (9, '2019-10-02 15:00:00', 10.3);
INSERT INTO public.precipitation VALUES (10, '2019-10-23 16:00:00', 14.3);
INSERT INTO public.precipitation VALUES (11, '2019-10-23 17:00:00', 1.1);
INSERT INTO public.precipitation VALUES (12, '2019-10-23 18:00:00', 0.1);
INSERT INTO public.precipitation VALUES (13, '2019-11-02 13:00:00', 2.5);
INSERT INTO public.precipitation VALUES (14, '2019-11-02 14:00:00', 0.5);
INSERT INTO public.precipitation VALUES (15, '2019-11-02 15:00:00', 20.5);
INSERT INTO public.precipitation VALUES (16, '2019-11-23 16:00:00', 5.1);
INSERT INTO public.precipitation VALUES (17, '2019-11-23 17:00:00', 10.4);
INSERT INTO public.precipitation VALUES (19, '2019-12-02 13:00:00', 1.3);
INSERT INTO public.precipitation VALUES (18, '2019-11-23 18:00:00', 1.5);
INSERT INTO public.precipitation VALUES (20, '2019-12-02 13:00:00', 1.3);
INSERT INTO public.precipitation VALUES (21, '2019-12-02 14:00:00', 11);
INSERT INTO public.precipitation VALUES (22, '2019-12-02 15:00:00', 20.5);
INSERT INTO public.precipitation VALUES (23, '2019-12-23 16:00:00', 34.6);
INSERT INTO public.precipitation VALUES (24, '2019-12-23 17:00:00', 1.9);
INSERT INTO public.precipitation VALUES (25, '2019-12-23 18:00:00', 0.5);
INSERT INTO public.precipitation VALUES (26, '2020-09-02 13:00:00', 3.5);
INSERT INTO public.precipitation VALUES (27, '2020-09-02 14:00:00', 4.6);
INSERT INTO public.precipitation VALUES (28, '2020-09-02 15:00:00', 0.5);
INSERT INTO public.precipitation VALUES (29, '2020-09-23 16:00:00', 0.1);
INSERT INTO public.precipitation VALUES (30, '2020-09-23 17:00:00', 0);
INSERT INTO public.precipitation VALUES (31, '2020-09-23 18:00:00', 0.1);
INSERT INTO public.precipitation VALUES (32, '2020-10-02 13:00:00', 10.5);
INSERT INTO public.precipitation VALUES (33, '2020-10-02 14:00:00', 1.6);
INSERT INTO public.precipitation VALUES (34, '2020-10-02 15:00:00', 2.5);
INSERT INTO public.precipitation VALUES (35, '2020-10-23 16:00:00', 0.2);
INSERT INTO public.precipitation VALUES (36, '2020-10-23 17:00:00', 0.6);
INSERT INTO public.precipitation VALUES (37, '2020-10-23 18:00:00', 0);


--
-- Name: precipitation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.precipitation_id_seq', 37, true);


--
-- Name: precipitation precipitation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.precipitation
    ADD CONSTRAINT precipitation_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

