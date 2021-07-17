# Geektrust-MakeSpace

## The challenge
Make Space Ltd. is a startup offering a co-working space to individuals, freelancers and startups. They provide a common workspace where anyone can come and work. Along with it, they have dedicated meeting rooms that their customers can book for private discussions.

They are looking for a scheduling system to effectively schedule meetings. Can you build such a system for Make Space Ltd.?

Make Space Ltd. currently has 3 meeting rooms with varying capacity

| Name        | Person Capacity           |
| ------------- |:-------------:|
| C-Cave      | 3 People |
| D-Tower      | 7 People      |
| G-Mansion | 20 People      |

Person Capacity - Maximum number of people the meeting room can accommodate.<br />
Buffer Time - Buffer time is the time used to clean up the meeting room. It happens at fixed times from 09:00 - 09:15, 13:15 - 13:45 and 18:45 - 19:00. During this time, no meeting rooms will be available to book.

## Rules
1. Bookings can be made only in a single day from 00:00 to night 23:45. It cannot overlap across days. So you cannot book from 23:00 to 01:00, but can from 23:00 to 23:45.
2. A booking can be started and ended only in 15 minute intervals, i.e. XX:00, XX:15, XX:30, XX:45. This means a booking can be made at 01:15 or 16:00 but not 15:35 or 16:03.
3. The rooms will be allocated only to those who book them, on a first come first serve basis.
4. The most optimal room which can accommodate the number of people will be allocated. For eg., if you asked for a 4 person capacity requirement then the D-Tower (7 person capacity) will be allocated, provided it is available.
5. In case if the room of desired capacity is not available, the next available capacity room will be allocated. For eg., If you asked for the 4 person capacity room between 12:00 to 13:00 and the D-Tower is not available then the G-Mansion will be allocated, provided it is available.
6. No meetings can be scheduled during the buffer time. If the booking time overlaps with the buffer time NO_VACANT_ROOM should be printed.
7. Time input should follow HH:MM format (24 hours format). If an incorrect time input is provided then INCORRECT_INPUT should be printed.

##Input Details
#### 1. Book Meeting Room
As a co-working space customer, I shall schedule a meeting by giving a time period and capacity requirement.<br />
Format - BOOK <start_time(inclusive)> <end_time(exclusive)> <person_capacity><br />
Example - BOOK 14:15 16:00 12
Possible Output:
“<Meeting_Room_Name>” - If the booking is successful
“NO_VACANT_ROOM” - If no room is vacant during the requested time period.

#### 2. View available meeting rooms
As a co-working space customer, I would like to view a list of available meeting rooms by giving a time period. This should print the rooms in the ascending order of the room capacity. The rooms printed should be separated by a single space character.<br />
Format - VACANCY <start_time(inclusive)> <end_time(exclusive)><br />
Example - VACANCY 14:30 15:00<br />
Output: C-Cave G-Mansion


## Input Constraints

1. Time will be in HH:MM (24 hours) format
2. Time input should always consider the 15 minute time interval
3. For all the time inputs end_time > start_time
4. person_capacity >= 2 and person_capacity <= 20

## How to run the application
1. Clone the project to your local system.
2. Go to project directory and run `mvn clean install`.
3. Go to `<path_to_project_directory>/target` and run `java -jar geektrust.jar <path_to_input_file>`

Sample input files attached under `./resources`.

## Sample Input-Output
| INPUT               | OUTPUT                   |
| ------------------- | ------------------------ |
| VACANCY 10:00 12:00 | C-Cave D-Tower G-Mansion |
| BOOK 11:00 11:45 2  | C-Cave                   |
| BOOK 11:30 13:00 35 | NO\_VACANT\_ROOM         |
| BOOK 11:30 13:00 15 | G-Mansion                |
| VACANCY 11:30 12:00 | D-Tower                  |
| BOOK 14:00 15:30 3  | C-Cave                   |
| BOOK 15:00 16:30 2  | D-Tower                  |
| BOOK 15:15 12:15 12 | INCORRECT\_INPUT         |
| VACANCY 15:30 16:00 | C-Cave G-Mansion         |
| BOOK 15:30 16:30 2  | C-Cave                   |
| VACANCY 15:45 16:00 | G-Mansion                |
| BOOK 16:00 17:00 5  | G-Mansion                |
| VACANCY 18:00 19:00 | NO\_VACANT\_ROOM         |
