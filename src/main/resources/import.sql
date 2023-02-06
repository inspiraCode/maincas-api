INSERT INTO company (id, created_by, created_date, last_modified_by, last_modified_date, address_city, address_country, address_line_one, address_line_two, address_state, address_zip, alias, block, name, roles) VALUES (1, 'google-oauth2|118214196146974270990', '2023-02-05 12:32:34.256', 'google-oauth2|118214196146974270990', '2023-02-05 12:32:34.256', 'El Paso', 'United States', '4428 Franklin Ridge Ave', '', 'TX', '74414', 'Electronic Components El Paso', false, 'Electronic Components LLC', 'SELLER');
INSERT INTO company (id, created_by, created_date, last_modified_by, last_modified_date, address_city, address_country, address_line_one, address_line_two, address_state, address_zip, alias, block, name, roles) VALUES (2, 'google-oauth2|118214196146974270990', '2023-02-05 12:33:43.012', 'google-oauth2|118214196146974270990', '2023-02-05 12:33:43.012', 'Ciudad Juarez', 'Mexico', 'Ave 5 de Mayo 3312', 'Col. El Barreal', 'Chihuahua', '31486', 'Raw Plastics Juarez', false, 'Raw Plastics SA de CV', 'SELLER');
INSERT INTO company (id, created_by, created_date, last_modified_by, last_modified_date, address_city, address_country, address_line_one, address_line_two, address_state, address_zip, alias, block, name, roles) VALUES (3, 'google-oauth2|118214196146974270990', '2023-02-05 12:34:54.303', 'google-oauth2|118214196146974270990', '2023-02-05 12:34:54.303', 'Ciudad Juarez', 'Mexico', 'Calle Miguel de la Madrid 719', 'Parq. Ind. Omega', 'Chihuahua', '31428', 'Componentes Industriales Juarez', false, 'Componentes Industriales de la Frontera SA de CV', 'BUYER');

--
-- Data for Name: tariff_schedule; Type: TABLE DATA; Schema: public; Owner: maincas
--

INSERT INTO tariff_schedule (id, created_by, created_date, last_modified_by, last_modified_date, base_description, code, document_description, observations, ust) VALUES (1, 'google-oauth2|118214196146974270990', '2023-02-05 12:54:16.532', 'google-oauth2|118214196146974270990', '2023-02-05 12:54:16.532', 'Válvula de purga para compresor, se presenta desarmada', '0901.21.0120', 'KT, VALVE, BLOWDOWN', 'observaciones para frac. arancelaria', 'Lbs');


--
-- Data for Name: material; Type: TABLE DATA; Schema: public; Owner: maincas
--
INSERT INTO material (id,created_by,created_date,last_modified_by,last_modified_date,approved_impo,commercial_description,legal_description,observations,sed_description,buyer_id,sed_tariff_id,seller_id,tariff_id) VALUES
	 (1,'google-oauth2|118214196146974270990','2023-02-05 19:54:33.373','google-oauth2|118214196146974270990','2023-02-05 19:54:33.373',true,'KT,VALVE,BLOWDOWN','Valvula de purga para compresor, se presenta desarmada','Observaciones de valvula de purga','KT,VALVE,BLOWDOWN',3,1,1,1);




--
-- Data for Name: material_aud; Type: TABLE DATA; Schema: public; Owner: maincas
--



--
-- Data for Name: tariff_schedule_aud; Type: TABLE DATA; Schema: public; Owner: maincas
--

INSERT INTO tariff_schedule_aud (id, rev, revtype, created_by, created_by_mod, created_date, created_date_mod, last_modified_by, last_modified_by_mod, last_modified_date, last_modified_date_mod, base_description, base_description_mod, code, code_mod, document_description, document_description_mod, observations, observations_mod, ust, ust_mod) VALUES (7, 8, 0, 'google-oauth2|118214196146974270990', true, '2023-02-05 12:54:16.532', true, 'google-oauth2|118214196146974270990', true, '2023-02-05 12:54:16.532', true, 'Válvula de purga para compresor, se presenta desarmada', true, '0901.21.0120', true, 'KT, VALVE, BLOWDOWN', true, NULL, false, 'Lbs', true);


