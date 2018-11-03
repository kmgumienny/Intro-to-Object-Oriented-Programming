Kamil Gumienny- kmgumienny

## Description
This project is built on starter files and takes in user actions and analyzes them for abnormalities in order to detect detect breach attempts. For example, if a user is trying to save a file larger than 1GB, an alert object is created. If a user has > 10  failed login attempts a trigger will also be raised. These alerts are loaded into a priority queue.

The SecurityMonitor class defines a priority queue on alerts and provides some methods for accessing information about the queues. The monitor’s constructor takes a list of patterns as input.
