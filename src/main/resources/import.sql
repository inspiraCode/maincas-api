INSERT INTO company (id, created_by, created_date, last_modified_by, last_modified_date, address_city, address_country, address_line_one, address_line_two, address_state, address_zip, alias, block, name, roles) VALUES (1, 'google-oauth2|118214196146974270990', '2023-02-05 12:32:34.256', 'google-oauth2|118214196146974270990', '2023-02-05 12:32:34.256', 'El Paso', 'United States', '4428 Franklin Ridge Ave', '', 'TX', '74414', 'Electronic Components El Paso', false, 'Electronic Components LLC', 'SELLER');
INSERT INTO company (id, created_by, created_date, last_modified_by, last_modified_date, address_city, address_country, address_line_one, address_line_two, address_state, address_zip, alias, block, name, roles) VALUES (3, 'google-oauth2|118214196146974270990', '2023-02-05 12:33:43.012', 'google-oauth2|118214196146974270990', '2023-02-05 12:33:43.012', 'Ciudad Juarez', 'Mexico', 'Ave 5 de Mayo 3312', 'Col. El Barreal', 'Chihuahua', '31486', 'Raw Plastics Juarez', false, 'Raw Plastics SA de CV', 'SELLER');
INSERT INTO company (id, created_by, created_date, last_modified_by, last_modified_date, address_city, address_country, address_line_one, address_line_two, address_state, address_zip, alias, block, name, roles) VALUES (5, 'google-oauth2|118214196146974270990', '2023-02-05 12:34:54.303', 'google-oauth2|118214196146974270990', '2023-02-05 12:34:54.303', 'Ciudad Juarez', 'Mexico', 'Calle Miguel de la Madrid 719', 'Parq. Ind. Omega', 'Chihuahua', '31428', 'Componentes Industriales Juarez', false, 'Componentes Industriales de la Frontera SA de CV', 'BUYER');

--
-- Data for Name: company_aud; Type: TABLE DATA; Schema: public; Owner: maincas
--

INSERT INTO company_aud (id, rev, revtype, created_by, created_by_mod, created_date, created_date_mod, last_modified_by, last_modified_by_mod, last_modified_date, last_modified_date_mod, address_city, address_city_mod, address_country, address_country_mod, address_line_one, address_line_one_mod, address_line_two, address_line_two_mod, address_state, address_state_mod, address_zip, address_zip_mod, alias, alias_mod, block, block_mod, name, name_mod, roles, roles_mod) VALUES (1, 2, 0, 'google-oauth2|118214196146974270990', true, '2023-02-05 12:32:34.256', true, 'google-oauth2|118214196146974270990', true, '2023-02-05 12:32:34.256', true, 'El Paso', true, 'United States', true, '4428 Franklin Ridge Ave', true, '', true, 'TX', true, '74414', true, 'Electronic Components El Paso', true, false, true, 'Electronic Components LLC', true, 'SELLER', true);
INSERT INTO company_aud (id, rev, revtype, created_by, created_by_mod, created_date, created_date_mod, last_modified_by, last_modified_by_mod, last_modified_date, last_modified_date_mod, address_city, address_city_mod, address_country, address_country_mod, address_line_one, address_line_one_mod, address_line_two, address_line_two_mod, address_state, address_state_mod, address_zip, address_zip_mod, alias, alias_mod, block, block_mod, name, name_mod, roles, roles_mod) VALUES (3, 4, 0, 'google-oauth2|118214196146974270990', true, '2023-02-05 12:33:43.012', true, 'google-oauth2|118214196146974270990', true, '2023-02-05 12:33:43.012', true, 'Ciudad Juarez', true, 'Mexico', true, 'Ave 5 de Mayo 3312', true, 'Col. El Barreal', true, 'Chihuahua', true, '31486', true, 'Raw Plastics Juarez', true, false, true, 'Raw Plastics SA de CV', true, 'SELLER', true);
INSERT INTO company_aud (id, rev, revtype, created_by, created_by_mod, created_date, created_date_mod, last_modified_by, last_modified_by_mod, last_modified_date, last_modified_date_mod, address_city, address_city_mod, address_country, address_country_mod, address_line_one, address_line_one_mod, address_line_two, address_line_two_mod, address_state, address_state_mod, address_zip, address_zip_mod, alias, alias_mod, block, block_mod, name, name_mod, roles, roles_mod) VALUES (5, 6, 0, 'google-oauth2|118214196146974270990', true, '2023-02-05 12:34:54.303', true, 'google-oauth2|118214196146974270990', true, '2023-02-05 12:34:54.303', true, 'Ciudad Juarez', true, 'Mexico', true, 'Calle Miguel de la Madrid 719', true, 'Parq. Ind. Omega', true, 'Chihuahua', true, '31428', true, 'Componentes Industriales Juarez', true, false, true, 'Componentes Industriales de la Frontera SA de CV', true, 'BUYER', true);


--
-- Data for Name: tariff_schedule; Type: TABLE DATA; Schema: public; Owner: maincas
--

INSERT INTO tariff_schedule (id, created_by, created_date, last_modified_by, last_modified_date, base_description, code, document_description, observations, ust) VALUES (7, 'google-oauth2|118214196146974270990', '2023-02-05 12:54:16.532', 'google-oauth2|118214196146974270990', '2023-02-05 12:54:16.532', 'Válvula de purga para compresor, se presenta desarmada', '0901.21.0120', 'KT, VALVE, BLOWDOWN', NULL, 'Lbs');


--
-- Data for Name: material; Type: TABLE DATA; Schema: public; Owner: maincas
--



--
-- Data for Name: material_aud; Type: TABLE DATA; Schema: public; Owner: maincas
--



--
-- Data for Name: tariff_schedule_aud; Type: TABLE DATA; Schema: public; Owner: maincas
--

INSERT INTO tariff_schedule_aud (id, rev, revtype, created_by, created_by_mod, created_date, created_date_mod, last_modified_by, last_modified_by_mod, last_modified_date, last_modified_date_mod, base_description, base_description_mod, code, code_mod, document_description, document_description_mod, observations, observations_mod, ust, ust_mod) VALUES (7, 8, 0, 'google-oauth2|118214196146974270990', true, '2023-02-05 12:54:16.532', true, 'google-oauth2|118214196146974270990', true, '2023-02-05 12:54:16.532', true, 'Válvula de purga para compresor, se presenta desarmada', true, '0901.21.0120', true, 'KT, VALVE, BLOWDOWN', true, NULL, false, 'Lbs', true);


