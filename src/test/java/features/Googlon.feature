Feature: Googlon Language Processor
	Processes the googlon text and evaluate the number of verbs, prepositions and subjunctives along with its numerical equivalent.
	
	Scenario: Processing a valid googlon text
		Given a working googlon processor
		When The input text is "shoce pq podciy nfwh phfer epgdc dgsloqe do rhfl qhmoixw cmfur qdrulxogji whc ermjdhsx py en yco ienqm wjuln dwuch qinhmjul mjxdqfrnlg iygsex qihmu grewyluhfs ucf us xclpedqmi yrx qinexwo qx rqw wxflpdn rsogxd cpqmxj lgchqdin fdw nwcrus coj nj qplfjnwidg fwdmslqn cwj hysucxdqm ms hdmwpe igxweo sqflo ycqlinro ghu hgecdfj mw xrpmyenq fgixsr fpwcnguieh fclgj ghepqyd jxhwe cejfugn ujxqh ihncrl mlceo udr fm ocxfsjdng sfoqmd pdoymnwxei spqinedf ql ncsepfl icmqsdj chwjlg yiq ifl syejrqd lwnepmcg xlmnfqry ghlyopuncw qx iw sionpux cop dmqpchuyf ojxfqhernm ignpeyf rseoyl emjocsild rfimdy mwd oewgjfr uo irmcunfgx ylduwpsnh xrdng gcxr ng prfmjicud srdueqhgiy nmodwsqijh dcnql"
		Then There are 3 prepositions in the text
		And There are 36 verbs in the text
		And There are 25 subjunctive verbs in the text
		And Vocabulary list: "sqflo spqinedf sfoqmd syejrqd shoce srdueqhgiy sionpux xclpedqmi xlmnfqry xrpmyenq xrdng ocxfsjdng oewgjfr ojxfqhernm cop coj cmfur cwj cpqmxj chwjlg cejfugn qx qplfjnwidg qhmoixw ql qdrulxogji qinhmjul qinexwo qihmu ncsepfl nmodwsqijh nwcrus nfwh nj ng ms mw mwd mlceo mjxdqfrnlg wxflpdn whc wjuln podciy pq py phfer prfmjicud pdoymnwxei fclgj fm fwdmslqn fpwcnguieh fdw fgixsr yco ycqlinro ylduwpsnh yrx yiq hysucxdqm hdmwpe hgecdfj en emjocsild epgdc ermjdhsx lwnepmcg lgchqdin jxhwe rsogxd rseoyl rqw rfimdy rhfl do dcnql dmqpchuyf dwuch dgsloqe gcxr ghepqyd ghlyopuncw ghu grewyluhfs us uo ucf ujxqh udr icmqsdj iw ifl iygsex ihncrl ienqm irmcunfgx igxweo ignpeyf""
		And There are 22 distinct pretty numbers in the text
		
