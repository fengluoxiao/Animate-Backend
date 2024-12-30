#!/bin/bash
kill $(cat app.pid)
rm app.pid 