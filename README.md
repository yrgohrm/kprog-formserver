# kprog-formserver

## General

This is a simple web service that echoes back form data (url encoded forms and query parameters).

## Running

How to start the kprog-formserver application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/kprog-formserver-1.0.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

It is possible to configure the port in config.yml.

## API

The API is very simple and has two endpoints that both returns a web page.

### GET /api/echo?...

Will return a web page containing the query parameters as text. The parameters will be escaped properly.

### POST /api/echo?...

The same as the GET variant but also includes any url encoded form data.

### GET /api/unsafeecho?...

Will return a web page containing the query parameters as text. The parameters will *not* be escaped properly.

### POST /api/unsafeecho?...

The same as the GET variant but also includes any url encoded form data.
