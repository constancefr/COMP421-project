-- Include your INSERT SQL statements in this file.
-- Make sure to terminate each statement with a semicolon (;)

-- LEAVE this statement on. It is required to connect to your database.
CONNECT TO COMP421;

-- Remember to put the INSERT statements for the tables with foreign key references
--    ONLY AFTER the insert for the parent tables!

-- This is only an example of how you add INSERT statements to this file.
--   You may remove it.
--INSERT INTO MYTEST01 (id, value) VALUES(4, 1300);

-- A more complex syntax that saves you typing effort.
--INSERT INTO MYTEST01 (id, value) VALUES
-- (7, 5144),
-- (3, 73423),
-- (6, -1222)
--;

-- Rewards Members
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00005', 'Amby Durrans', 'adurrans0@ucsd.edu', '3797452772', '1012 90th Avenue, Brooks AB T0J 0J0', '4737862424755810', '46098';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00006', 'Sharline Dykerline', 'sdykerline1@google.es', '4123706313', '391 rue Saint-Édouard, Trois Rivieres QC G9A 5S8', '4017953717472910', '45555';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00009', 'Welby Rapson', 'wrapson2@plala.or.jp', '8985502944', '2958 Beaver Creek, Thornhill ON L4J 1W2', '4753362994311', '46084';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00012', 'Sharline Whiteway', 'swhiteway3@ezinearticles.com', '4183900852', '2422 Central Pkwy, Mississauga ON L5L 5S1', '4041373700947', '45820';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00014', 'Brigham Trevain', 'btrevain4@tuttocitta.it', '4959883199', '148 Pape Ave, Toronto ON M4E 2V5', '4622289538636', '45460';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00021', 'Aliza Cicchillo', 'acicchillo5@4shared.com', '5835206388', '4798 René-Lévesque Blvd, Montreal QC H3B 4W8', '4041595863648', '46189';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00023', 'Cad Jills', 'cjills6@umich.edu', '8937189675', '622 Nelson Street, Big Trout Lake ON P0V 1G0', '4041592621098', '46583';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00024', 'Charmaine Scrinage', 'cscrinage7@ucla.edu', '2182436704', '4637 Fallon Drive, Chesley ON N0G 1L0', '4041594982837', '46880';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00027', 'Tammi Osband', 'tosband8@chicagotribune.com', '4272026547', '2229 Lockhart Drive, Barrie ON L4M 3B1', '4017957604986', '46559';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00028', 'Giffie Gutsell', 'ggutsell9@netlog.com', '3006492026', '4369 Wallbridge Loyalist Rd, Belleville ON K8N 1L9', '4041593771777', '45539';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00029', 'Maureen Pillington', 'mpillingtona@nationalgeographic.com', '5308230969', '169 rue des Églises Est, Malartic QC J0Y 1Z0', '4041374985018', '45766';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00032', 'Darlene Karys', 'dkarysb@xrea.com', '4518956001', '2421 Yonge Street, Toronto ON M4W 1J7', '4041376913422', '46397';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00036', 'Roth Lazarus', 'rlazarusc@wordpress.com', '1054073745', '1807 Albert Street, Herbert SK S4P 3Y2', '4017950116376', '46113';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00038', 'Horatius Elsip', 'helsipd@liveinternet.ru', '5178981980', '3594 Reserve St, Frankford ON K0K 2C0', '4041590283759880', '46261';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00041', 'Biddie Worwood', 'bworwoode@deliciousdays.com', '5408027327', '4862 Reserve St, Cambray ON K0M 1E0', '4293705302899470', '45829';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00043', 'Bogart Seyler', 'bseylerf@ebay.co.uk', '2961816019', '3941 Danforth Avenue, Toronto ON M4K 1A6', '4041597580393000', '46717';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00044', 'Cathleen Okey', 'cokeyg@reddit.com', '9225666152', '173 Heritage Drive, Calgary AB T2V 2W2', '4017957388350560', '45875';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00046', 'Anetta Johnigan', 'ajohniganh@4shared.com', '7586577268', '3572 Bloor Street, Vegreville AB T0B 4L0', '4041593824456150', '45700';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00049', 'Terry Jannex', 'tjannexi@wordpress.org', '1858909794', '391 St. John Street, Viscount SK S4P 3Y2', '4041370940991', '47218';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00053', 'Emilie Chazerand', 'echazerandj@unc.edu', '4848198982', '4511 Main St, Theodore SK S0A 4C0', '4017951159490', '45816';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00054', 'Verne Ainslie', 'vainsliek@drupal.org', '3108257797', '3705 Nelson Street, Delvin ON POW 1C0', '4041591243860', '45979';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00055', 'Hashim Lecount', 'hlecountl@4shared.com', '4571474412', '1423 rue Levy, Montreal QC H3C 5K4', '4017951285907', '46268';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00059', 'Dana Fer', 'dferm@webmd.com', '5022432401', '752 Tanner Street, Vancouver BC V5R 2T4', '4614246702744', '45887';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00060', 'Mar Flatte', 'mflatten@slate.com', '9085964182', '2353 rue des Églises Est, Rochebaucourt QC J0Y 2J0', '4041378689317230', '46272';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00063', 'Michelina Meharg', 'mmehargo@scientificamerican.com', '1151123913', '3970 Bloor Street, Ardrossan AB T0B 0E0', '4041377031827430', '45778';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00064', 'Edik Muston', 'emustonp@technorati.com', '8752201510', '4559 Riedel Street, Fort Mcmurray AB T9H 3J9', '4041376773592060', '46287';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00065', 'Estella Drust', 'edrustq@merriam-webster.com', '9437714994', '2169 St. Paul Street, St Catharines ON L2S 2K4', '4041596171348', '45703';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00071', 'Janeta Cubley', 'jcubleyr@multiply.com', '8678144208', '4065 Eglinton Avenue, Tornoto ON M4P 16A', '4041592211411', '46892';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00078', 'Garwood Van Daalen', 'gvans@gmpg.org', '6026650039', '2681 St-Jerome Street, St Jerome QC S4P 3Y2', '4017959513199740', '46512';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00083', 'Netty Papen', 'npapent@miibeian.gov.cn', '9894022558', '4046 40th Street, Calgary AB T2M 0G6', '4041599849026570', '45663';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00085', 'Ganny Seifenmacher', 'gseifenmacheru@amazonaws.com', '7683740593', '316 Bay Street, Toronto ON M5J 2R8', '4017952163400', '45452';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00086', 'Alyse Brolan', 'abrolanv@illinois.edu', '4684908522', '2893 137th Avenue, Edmonton AB T5M 3K3', '4041370616109430', '46122';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00087', 'Hana Patton', 'hpattonw@va.gov', '6974450700', '559 rue Fournier, St Jerome QC J7Z 4V1', '4041372737742', '46081';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00093', 'Romeo Boundley', 'rboundleyx@yandex.ru', '5362546684', '497 Bellwood Acres Rd, Huntsville ON P0A 1K0', '4195675707735', '45794';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00094', 'Tomlin Tesyro', 'ttesyroy@senate.gov', '8225883131', '3611 Brew Creek Rd, Vananda BC V0N 3K0', '4919050449419', '45811';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00096', 'Amargo Drummond', 'adrummondz@deliciousdays.com', '5537473110', '2249 René-Lévesque Blvd, Montreal QC H3B 4W8', '4505154701340', '46714';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00106', 'Kile Kinchington', 'kkinchington10@arstechnica.com', '8257593416', '796 avenue Royale, Quebec QC G1P 4R5', '4446199013286', '45572';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00107', 'Natassia Lelievre', 'nlelievre11@macromedia.com', '8523939372', '3385 40th Street, Calgary AB T2K 0P7', '4041593433592', '45557';

-- Guests
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00001', 'Christi Perks', 'cperks12@arizona.edu', '4754913050', '1377 Glover Road, Fort Langley BC V3A 6X5', '4041593957616', '45693';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00002', 'Anthony Lorens', 'alorens13@mashable.com', '2253858525', '2312 40th Street, Calgary AB T2C 2P3', '4017951412923', '46262';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00003', 'Dav Brennen', 'dbrennen14@dedecms.com', '8326187821', '3145 Richford Road, Napierville QC J0J 1L0', '4041372888818', '46860';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00004', 'Ozzy Guilleton', 'oguilleton15@fema.gov', '9404875011', '4078 Riedel Street, Fort Mcmurray AB T9H 3J9', '4017951301282', '45672';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00007', 'Rayner Gabites', 'rgabites16@ibm.com', '8833618880', '1011 Tolmie St, Vancouver BC V6R 4C5', '4017955853290420', '46460';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00008', 'Alika Chewter', 'achewter17@salon.com', '2673929755', '2125 Parkdale Ave, Brockville ON K6V 4X4', '4041598158434160', '46166';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00010', 'Lenette Maffy', 'lmaffy18@nature.com', '8785030805', '1914 Parkdale Ave, Cornwall ON K6J 3P7', '4041370373763', '46605';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00011', 'Tailor Tohill', 'ttohill19@mlb.com', '5641023792', '1145 Montreal Road, Ottawa ON K1L 6C7', '4041592511485590', '46892';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00013', 'Michail McCole', 'mmccole1a@php.net', '5468910997', '2124 Adelaide St, Toronto ON M5H 1P6', '4570357779441940', '45631';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00015', 'Lin Vernay', 'lvernay1b@mit.edu', '9937100765', '969 Brand Road, Saskatoon SK S7K 1W8', '4017954725008', '46694';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00016', 'Kelsey Wratten', 'kwratten1c@miitbeian.gov.cn', '6506223046', '2051 Birkett Lane, Brantford ON N3T 2Z8', '4041371419359', '45772';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00017', 'Mickie Crosser', 'mcrosser1d@usa.gov', '1678559819', '1536 Blanshard, Victoria BC V8W 2H9', '4378922809014730', '45727';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00018', 'Bobbette Pettingill', 'bpettingill1e@wufoo.com', '5976044538', '2639 Sherbrooke Ouest, Montreal QC H4A 1H3', '4844132857969610', '46908';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00019', 'Ezequiel Figiovanni', 'efigiovanni1f@webeden.co.uk', '4927292945', '51 rue St-Henri, Ville Le Gardeur QC J5Z 1R6', '4094255712548', '46715';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00020', 'Bethena Danser', 'bdanser1g@reference.com', '3084398375', '1617 Main St, Manor SK S0C 1R0', '4468560327724840', '45915';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00022', 'Michal Surphliss', 'msurphliss1h@fc2.com', '7979374509', '2242 Carlson Road, Prince George BC V2L 5E5', '4041371744400740', '45765';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00025', 'Anita McLachlan', 'amclachlan1i@google.com.br', '3032148270', '4588 Merivale Road, Stittsville ON K2S 1B9', '4041595034066980', '45733';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00026', 'Raeann Joselin', 'rjoselin1j@bandcamp.com', '8306171146', '2650 St Jean Baptiste St, St Magloire QC G0R 3M0', '4041373841451', '45668';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00030', 'Hamlin Edwardson', 'hedwardson1k@fastcompany.com', '9145390257', '497 Bellwood Acres Rd, Huntsville ON P0A 1K0', '4041597749001', '46206';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00031', 'Anthe Tombleson', 'atombleson1l@msu.edu', '4202601856', '1818 Main St, Black Lake QC S0J 0H0', '4888113953350630', '46617';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00033', 'Bing Goshawk', 'bgoshawk1m@mtv.com', '9403770708', '3723 Robsonn St, Vancouver BC V6B 3K9', '4017958520484970', '45619';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00034', 'Oswell Skehens', 'oskehens1n@vk.com', '6448346899', '2092 Nelson Street, Pass Lake ON P0T 2M0', '4041375234437900', '45851';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00035', 'Etan Frammingham', 'eframmingham1o@dell.com', '7596040502', '2893 Runnymede Rd, Toronto ON M6S 2Z7', '4017953621145190', '47070';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00037', 'Ludwig Speeding', 'lspeeding1p@plala.or.jp', '3045271702', '833 Nelson Street, Nobel QC P0G 1G0', '4041595076863660', '46603';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00039', 'Thoma Wiffen', 'twiffen1q@cbslocal.com', '7641039850', '1163 Weir Crescent, Toronto ON M1E 3T8', '4617772593518730', '46659';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00040', 'Abbey Mifflin', 'amifflin1r@skyrock.com', '9147042956', '2667 rue des Églises Est, Lavenir QC J0C 1B0', '4041593358852400', '46688';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00042', 'Dillie Dregan', 'ddregan1s@reddit.com', '2129745343', '1152 rue Levy, Montreal QC H3C 5K4', '4545714062635', '46986';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00045', 'Blakelee Moorfield', 'bmoorfield1t@yahoo.com', '5815952444', '2638 Heatherleigh, Cooksville ON L5A 1V9', '4017956559447', '45560';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00047', 'Godwin Dearle-Palser', 'gdearlepalser1u@flavors.me', '4869449133', '4573 Tycos Dr, Toronto ON M5T 1T4', '4553485092716', '46936';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00048', 'Angel Buttwell', 'abuttwell1v@github.io', '5164990652', '1942 Victoria Park Ave, Toronto ON M2J 3T7', '4353610915133', '46832';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00050', 'Katrinka Lavalde', 'klavalde1w@plala.or.jp', '2258628806', '3229 Fallon Drive, Dungannon ON N0M 1R0', '4041595254145', '46132';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00051', 'Lenka Scathard', 'lscathard1x@tmall.com', '7458128343', '2290 rue de la Gauchetière, Montreal QC H3B 2M3', '4017952347656', '47024';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00052', 'Drusy Godsal', 'dgodsal1y@weibo.com', '9559919932', '1306 Merivale Road, Kanata ON K2K 1L9', '4041593552906320', '46708';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00056', 'Robert Bargh', 'rbargh1z@tamu.edu', '2038224510', '3806 Fallon Drive, Durham ON N0G 1R0', '4017956367056', '47113';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00057', 'Audrye Grene', 'agrene20@imageshack.us', '6505876213', '1260 Bay Street, Toronto ON M5J 2R8', '4041599288933', '45571';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00058', 'Adolphe Vallens', 'avallens21@pbs.org', '8889737985', '1425 Speers Road, Maple ON L6A 1G5', '4041594885337', '45859';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00061', 'Raquela Rothwell', 'rrothwell22@indiegogo.com', '9047191042', '3803 Gateway Blvd, Edmonton AB T6H 1J5', '4631923152716630', '47149';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00062', 'Albie Shipton', 'ashipton23@flavors.me', '6288447091', '2333 Ontario St, St Catharines ON L2N 1S8', '4041373500008', '47030';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00066', 'Jarret Batistelli', 'jbatistelli24@arstechnica.com', '5463517835', '1519 René-Lévesque Blvd, Montreal QC H3B 4W8', '4041379785959', '46317';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00067', 'Edgardo Friary', 'efriary25@t.co', '6966698272', '699 Nelson Street, Hudson ON P0V 1X0', '4017953662363020', '46994';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00068', 'Jermaine Chadwick', 'jchadwick26@opera.com', '3197835000', '4394 Islington Ave, Toronto ON M9V 2X5', '4041590944179', '46002';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00069', 'Faye Raine', 'fraine27@walmart.com', '8185399420', '2304 Fallon Drive, Tiverton ON N0G 2T0', '4041590431423970', '46525';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00070', 'Kirsteni Tooting', 'ktooting28@ustream.tv', '8931571322', '557 rue Saint-Antoine, Granby QC J2H 2H5', '4002147693856580', '46864';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00072', 'Fanchette Zum Felde', 'fzum29@nymag.com', '8104968247', '86 Eglinton Avenue, Toronto ON M4P 1A6', '4041377345806', '45521';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00073', 'Stanislaw Diment', 'sdiment2a@yahoo.co.jp', '3205460730', '2325 Lock Street, Galt ON N1R 3Y8', '4041370974718930', '46944';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00074', 'Zaneta Olcot', 'zolcot2b@sogou.com', '6207836254', '2019 90th Avenue, Delia AB T0J 0W0', '4980367160479', '46676';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00075', 'Darrelle Sarfati', 'dsarfati2c@opensource.org', '9552867983', '4991 Bayfield St, Richmond Hill ON L4C 3Y2', '4041592272827', '45536';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00076', 'Linn Infantino', 'linfantino2d@blinklist.com', '4378547993', '4096 rue Ellice, Joliette QC J6E 3E8', '4041592168528080', '45754';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00077', 'Ambur Chimienti', 'achimienti2e@google.de', '3116504813', '4896 Whitmore Road, Fort Erie ON L0L 0L0', '4041599240439', '46239';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00079', 'Teresa Atkirk', 'tatkirk2f@uol.com.br', '1158253033', '291 Speers Road, Oakville ON L6H 3H5', '4017951833938', '45797';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00080', 'Paula Packington', 'ppackington2g@sbwire.com', '1885007943', '2424 Heritage Drive, Calgary AB T2V 2W2', '4053256935615990', '45814';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00081', 'Maxim Whitely', 'mwhitely2h@tumblr.com', '7702075165', '2546 Fallon Drive, Bayfield ON N0M 1G0', '4299025660715340', '47227';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00082', 'Chrystal Curr', 'ccurr2i@wunderground.com', '3355659882', '3973 Brand Road, Saskatoon SK S7K 1W8', '4336990067724', '46973';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00084', 'Ingemar Dean', 'idean2j@unicef.org', '7357095998', '615 90th Avenue, Schuler AB T0J 3B0', '4017952271997', '46307';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00088', 'Darci Gladeche', 'dgladeche2k@bbb.org', '4785745044', '635 Lynden Road, Orono ON L0B 1M0', '4247106027484830', '46849';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00089', 'Aarika Kalberer', 'akalberer2l@linkedin.com', '9092017521', '1682 MacLaren Street, Ottawa ON K1P 5M7', '4041373125905', '46032';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00090', 'Mose Lowrie', 'mlowrie2m@blogspot.com', '1905275515', '4058 49th Avenue, Qikiqtarjuaq NU X0A 0B0', '4369096480915840', '45650';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00091', 'Sylas Hizir', 'shizir2n@mashable.com', '2923310042', '1415 40th Street, Calgary AB T2P 4L4', '4041375326880410', '45480';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00092', 'Arin Ottery', 'aottery2o@issuu.com', '5529702956', '813 Blanshard, Victoria BC V8W 2H9', '4017953869997', '46963';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00095', 'Tracee Fontel', 'tfontel2p@fda.gov', '1806602789', '4313 Granville St, Halifax NS B3K 5L2', '4149172274947', '45692';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00097', 'Billi Wickson', 'bwickson2q@dailymail.co.uk', '3722565683', '1507 St. John Street, Beechy SK S4P 3Y2', '4230142483600', '46305';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00098', 'Darrick Labusquiere', 'dlabusquiere2r@dion.ne.jp', '9772462627', '818 Thurston Dr, Orleans ON K1C 1T1', '4041598939650', '46794';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00099', 'Doralyn Odney', 'dodney2s@epa.gov', '9053961671', '4596 Duke Street, Montreal QC H3C 5K4', '4827646418089', '45483';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00100', 'Brooks Bodill', 'bbodill2t@liveinternet.ru', '5856582148', '2676 Dufferin Street, Toronto ON M6H 4B6', '4041597539334970', '45633';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00101', 'Cleon Torbeck', 'ctorbeck2u@usatoday.com', '2004111101', '2764 rue des Érables, Clermont QC G4A 1J8', '4041372949727', '47020';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00102', 'Bobbi Chong', 'bchong2v@rambler.ru', '9756639080', '2531 King George Hwy, Surrey BC V3W 4E3', '4041377558457', '46469';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00103', 'Jorgan Binge', 'jbinge2w@java.com', '1923631917', '3504 Rose Street, Regina SK S4P 3Y2', '4017950298561080', '45462';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00104', 'Vincenty Petschel', 'vpetschel2x@intel.com', '8109238053', '4964 Blind Bay Road, Salmon Arm BC V0E 2T0', '4978849454569', '45758';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00105', 'Zaria Choules', 'zchoules2y@about.com', '4964357589', '2536 Sherbrooke Ouest, Montreal QC H4A 1H3', '4041591882477', '47247';
INSERT INTO Customer (cid, name, email, phone_number, address, ccnum, ccexpdate) VALUES '00108', 'Abran Fettes', 'afettes2z@disqus.com', '1025978534', '4098 rue Ellice, Joliette QC J6E 3E8', '4017957187676860', '47248';

-- Rewards Members
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00005', 'adurrans0', 'xK6|lSWM{i+', '9471';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00006', 'sdickerline1', 'qE9*EIVfuKO&"O7', '3298';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00009', 'wrapson2', 'vH4=@WA2"D&AJ2v', '4474';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00012', 'swhiteway3', 'xC1&/amfb8+JpGEQ', '6059';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00014', 'btrevain4', 'mK1+YF79j2', '3406';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00021', 'acicchillo5', 'iN6~B,EY4', '9042';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00023', 'cjills6', 'aK5?VSXoE', '2202';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00024', 'cscrinage7', 'mF7$#_q<`hv2wT+', '0';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00027', 'tosband8', 'dK6.vRO6', '6057';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00028', 'ggutsell9', 'lA1@Luq#vz|', '2990';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00029', 'mpillingtona', 'oF2=r2ZAS', '1005';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00032', 'dkarysb', 'sF7&|?F2c+', '1801';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00036', 'rlazarusc', 'dB7,h.sFm079&5K', '2386';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00038', 'helsipd', 'zF39s+T5Q', '2272';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00041', 'bworwoode', 'lI1\B>PIWbGJ%u@', '3592';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00043', 'bseylerf', 'lT9|$Cx&', '471';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00044', 'cokeyg', 'qO7%yyt-', '9944';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00046', 'ajohniganh', 'oL9~s1Pgp', '9373';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00049', 'tjannexi', 'mZ1!C?fwO', '4714';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00053', 'echazerandj', 'eB6kJxk$', '6951';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00054', 'vainsliek', 'oU2&X0aw>jk%h', '3831';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00055', 'hlecountl', 'wN3=<jf/k', '910';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00059', 'dferm', 'rY6.MWy_,XX&', '3718';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00060', 'mflatten', 'mR5%Ix!i%Lw', '137';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00063', 'mmehargo', 'kQ0|qijh=', '8852';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00064', 'emustonp', 'bI7@UeOS,', '5933';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00065', 'edrustq', 'nU8/ZQeK+uh', '2756';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00071', 'jcubleyr', 'xR3omzQM?TpOd3%', '2959';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00078', 'gvans', 'uU3.G~hKx', '5255';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00083', 'npapent', 'iV7,A<E@xWxMN', '6383';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00085', 'gseifenmacheru', 'vB6/,ps95AU', '5466';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00086', 'abrolanv', 'pJ1+5z.3/#', '6843';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00087', 'hpattonw', 'zC1wj8%0c&k1qO', '1175';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00093', 'rboundleyx', 'eD0l%*PDELzQI', '9207';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00094', 'ttesyroy', 'oF9=v1EZVQL@B', '3389';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00096', 'adrummondz', 'rL5d3GoUDP-wmsq', '4037';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00106', 'kkinchington10', 'kU2djsK5oK', '1574';
INSERT INTO RewardsMember (cid, login, pwd, points) VALUES '00107', 'nlelievre11', 'fS4=HyZSs+.sz', '1958';

-- Guests
INSERT INTO Guest (cid) VALUES '00001';
INSERT INTO Guest (cid) VALUES '00002';
INSERT INTO Guest (cid) VALUES '00003';
INSERT INTO Guest (cid) VALUES '00004';
INSERT INTO Guest (cid) VALUES '00007';
INSERT INTO Guest (cid) VALUES '00008';
INSERT INTO Guest (cid) VALUES '00010';
INSERT INTO Guest (cid) VALUES '00011';
INSERT INTO Guest (cid) VALUES '00013';
INSERT INTO Guest (cid) VALUES '00015';
INSERT INTO Guest (cid) VALUES '00016';
INSERT INTO Guest (cid) VALUES '00017';
INSERT INTO Guest (cid) VALUES '00018';
INSERT INTO Guest (cid) VALUES '00019';
INSERT INTO Guest (cid) VALUES '00020';
INSERT INTO Guest (cid) VALUES '00022';
INSERT INTO Guest (cid) VALUES '00025';
INSERT INTO Guest (cid) VALUES '00026';
INSERT INTO Guest (cid) VALUES '00030';
INSERT INTO Guest (cid) VALUES '00031';
INSERT INTO Guest (cid) VALUES '00033';
INSERT INTO Guest (cid) VALUES '00034';
INSERT INTO Guest (cid) VALUES '00035';
INSERT INTO Guest (cid) VALUES '00037';
INSERT INTO Guest (cid) VALUES '00039';
INSERT INTO Guest (cid) VALUES '00040';
INSERT INTO Guest (cid) VALUES '00042';
INSERT INTO Guest (cid) VALUES '00045';
INSERT INTO Guest (cid) VALUES '00047';
INSERT INTO Guest (cid) VALUES '00048';
INSERT INTO Guest (cid) VALUES '00050';
INSERT INTO Guest (cid) VALUES '00051';
INSERT INTO Guest (cid) VALUES '00052';
INSERT INTO Guest (cid) VALUES '00056';
INSERT INTO Guest (cid) VALUES '00057';
INSERT INTO Guest (cid) VALUES '00058';
INSERT INTO Guest (cid) VALUES '00061';
INSERT INTO Guest (cid) VALUES '00062';
INSERT INTO Guest (cid) VALUES '00066';
INSERT INTO Guest (cid) VALUES '00067';
INSERT INTO Guest (cid) VALUES '00068';
INSERT INTO Guest (cid) VALUES '00069';
INSERT INTO Guest (cid) VALUES '00070';
INSERT INTO Guest (cid) VALUES '00072';
INSERT INTO Guest (cid) VALUES '00073';
INSERT INTO Guest (cid) VALUES '00074';
INSERT INTO Guest (cid) VALUES '00075';
INSERT INTO Guest (cid) VALUES '00076';
INSERT INTO Guest (cid) VALUES '00077';
INSERT INTO Guest (cid) VALUES '00079';
INSERT INTO Guest (cid) VALUES '00080';
INSERT INTO Guest (cid) VALUES '00081';
INSERT INTO Guest (cid) VALUES '00082';
INSERT INTO Guest (cid) VALUES '00084';
INSERT INTO Guest (cid) VALUES '00088';
INSERT INTO Guest (cid) VALUES '00089';
INSERT INTO Guest (cid) VALUES '00090';
INSERT INTO Guest (cid) VALUES '00091';
INSERT INTO Guest (cid) VALUES '00092';
INSERT INTO Guest (cid) VALUES '00095';
INSERT INTO Guest (cid) VALUES '00097';
INSERT INTO Guest (cid) VALUES '00098';
INSERT INTO Guest (cid) VALUES '00099';
INSERT INTO Guest (cid) VALUES '00100';
INSERT INTO Guest (cid) VALUES '00101';
INSERT INTO Guest (cid) VALUES '00102';
INSERT INTO Guest (cid) VALUES '00103';
INSERT INTO Guest (cid) VALUES '00104';
INSERT INTO Guest (cid) VALUES '00105';
INSERT INTO Guest (cid) VALUES '00108';