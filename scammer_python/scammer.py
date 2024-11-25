import requests
import os
import random
import string
import json

chars = string.ascii_letters + string.digits + '!@#$%^&*()'
random.seed = (os.urandom(1024))


url = 'https://suministrosh2.com/lander/onep-turkiepetrol-4_1701876015/api.php?_lp=1&_token=uuid_12rl5f1fsflu_12rl5f1fsflu657ed5185fbff9.67211477'
names = json.loads(open('names.json').read())
surnames = json.loads(open('surname.json').read())


for i in range(5000):
	name_extra = ''.join(random.choice(surnames))
	email = name.lower() + name_extra + "@gmail.com"

	subid= "12rl5f1fsf6o"
	country= 'tr'
	phonecc= 90
	# name= 'Mehmet'
	# last= 'Açıkalın'
	surname = random.choice(surnames)
	# email= 'mhmetacik@gmail.com'
	# phone= "0123 456 34 45"
	phone = '0' + str(random.randint(500, 600)) + ' ' + str(random.randint(100, 999)) + ' ' + str(random.randint(10, 99)) + ' ' + str(random.randint(10, 99))
	
	requests.post(url=url, data={
		'subid': subid,
		'params[phc]': 90,
		'country': country,
		'phonecc' : phonecc,
		'name': name.lower(),
		'last' : surname,
		'email': email,
		'querys': [
		[1,"Evet, biliyordum"],
		[2,"Ailemin hiçbir şeye ihtiyacı olmasını istiyorum"],
		[3,"Hayır, daha önce hiç yatırım yapmadım."],
		[4,"70,000 TL'den"],
		[5, "Henüz karar vermedim."]
					],
		'phone': phone,
		'utm_term': "",
		'utm_medium': "",
		'utm_campaign': "",
		'utm_content': "",
		'utm_source': ""
	})

	print(f"name : {name}, last : {surname}, email : {email}, phone : {phone}")