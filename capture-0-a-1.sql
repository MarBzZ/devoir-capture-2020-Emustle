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

INSERT INTO public.precipitation VALUES (1, '2020-09-23 13:09:06', 25.12);
INSERT INTO public.precipitation VALUES (2, '2020-09-23 14:09:06', 20.5);
INSERT INTO public.precipitation VALUES (3, '2020-09-23 15:09:06', 6.14);
INSERT INTO public.precipitation VALUES (4, '2020-09-23 16:09:06', 0.2);
INSERT INTO public.precipitation VALUES (5, '2020-09-23 17:09:06', 0.3);
INSERT INTO public.precipitation VALUES (6, '2020-09-23 18:09:06', 0.1);
INSERT INTO public.precipitation VALUES (7, '2020-09-23 19:09:06', 0.1);
INSERT INTO public.precipitation VALUES (8, '2020-09-23 20:09:06', 0.3);
INSERT INTO public.precipitation VALUES (9, '2020-09-23 21:09:06', 10.3);
INSERT INTO public.precipitation VALUES (10, '2020-09-23 22:09:06', 14.32);


--
-- Name: precipitation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.precipitation_id_seq', 10, true);


--
-- Name: precipitation precipitation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.precipitation
    ADD CONSTRAINT precipitation_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

