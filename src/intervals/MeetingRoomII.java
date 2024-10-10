package intervals;
//https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/0
/*
* To solve this problem, the idea is to keep track of when meetings start and when they end, and see how many meetings are happening at the same time (i.e., how many rooms are required at any given point in time). A min-heap is used to keep track of ongoing meetings.

Steps:
Sort the Intervals:

Sort the intervals based on the start times (or alternatively, you can separate start times and end times into two different arrays).
Use a Min-Heap to Track End Times:

Use a min-heap to keep track of the end times of meetings. The heap will allow you to efficiently get the meeting that finishes the earliest.
As you iterate through the intervals, compare the start time of the current meeting with the end time at the top of the heap:
If the meeting at the top of the heap has ended (its end time is less than or equal to the start time of the current meeting), remove it from the heap (free the room).
Add the current meeting's end time to the heap (allocate a room).
Result:

The size of the heap at any point represents the number of rooms required at that time. The maximum size of the heap during the iteration will be the answer.
* */
public class MeetingRoomII {
}
