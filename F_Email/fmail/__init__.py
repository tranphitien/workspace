# Get the contact from a file
def get_contacts(file_name):
    names = []
    emails = []
    
    with open(file_name, mode='-r', encoding='utf-8') as contact_file:
        for a_contact in contact_file:
            names.append(a_contact.split()[0])
            emails.append(a_contact.split()[1])
    
    return names, emails

from string import Template

# Get the template message from a file
def read_template(file_name):
    with open(file_name, mode='-r', encoding='utf-8') as temp_file:
        temp_file_contain = temp_file.read()
    
    return Template(temp_file_contain)


import smtplib

SERVER = 'localhost'
SERVER = 'smtp-mail.outlook.com'

FROM = 'avuon1993@gmail.com'
TO = ['tphitien@gmail.com']

SUBJECT = "Test-SMTP"
TEXT = "This email was sent from Python - SMTP"

# Create an actual message
message = """\
From: %s
To: %s
Subject: %s

%s
""" % (FROM, ", ".join(TO), SUBJECT, TEXT)

# Set up SMTP server
server = smtplib.SMTP(host=SERVER, port='')
server.starttls()
server.login(FROM, "memory1471993")

# Send this email
server.sendmail(FROM, TO, message)

server.quit()