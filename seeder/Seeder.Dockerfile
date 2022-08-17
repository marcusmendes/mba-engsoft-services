FROM python:3

COPY requirements.txt /scripts/
COPY seed-database.py /scripts/

WORKDIR scripts

RUN ls -la

RUN pip install --no-cache-dir -r requirements.txt

CMD [ "python", "./seed-database.py" ]