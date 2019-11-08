package com.ssafy.step1.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MeetingRoomTest {
	static class MeetingRoom implements Comparable<MeetingRoom>{
		int no, start, end;
		
		public MeetingRoom(int no, int start, int end) {
			super();
			this.no = no;
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(MeetingRoom o) {
			int value = this.end - o.end;
			return value == 0 ? this.start - o.start : value;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		MeetingRoom list[] = new MeetingRoom[count];
		for(int i = 0; i < count; i++) {
			list[i] = new MeetingRoom(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		List<MeetingRoom> result = makeSchedule(list);
		System.out.println(result.size());
		for(MeetingRoom meetingRoom : result) {
			System.out.println(meetingRoom.no);
		}
	}
	
	private static List<MeetingRoom> makeSchedule(MeetingRoom[] list) {
		List<MeetingRoom> result = new ArrayList<MeetingRoom>();
		Arrays.sort(list);
		result.add(list[0]);
		for(int i = 1; i < list.length; i++) {
			if(result.get(result.size() - 1).end <= list[i].start) {
				result.add(list[i]);
			}
		}
		return result;		
	}
}
