package RESERVATIONN;

import java.util.Scanner;

class Room {
    private String roomNumber;
    private boolean isReserved;

    public Room(String roomNumber) {
        this.roomNumber = roomNumber;
        this.isReserved = false;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void reserveRoom() {
        isReserved = true;
    }

    public void cancelReservation() {
        isReserved = false;
    }
}

class Asset {
    private String assetName;
    private boolean isReserved;

    public Asset(String assetName) {
        this.assetName = assetName;
        this.isReserved = false;
    }

    public String getAssetName() {
        return assetName;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void reserveAsset() {
        isReserved = true;
    }

    public void cancelReservation() {
        isReserved = false;
    }
}

public class RoomBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Room[] rooms = new Room[5]; // Assuming we have 5 rooms
        Asset[] assets = new Asset[5]; // Assuming we have 5 assets

        // Initialize rooms and assets
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = new Room("Room " + (i + 1));
            assets[i] = new Asset("Asset " + (i + 1));
        }

        while (true) {
            System.out.println("1. Reserve Room");
            System.out.println("2. Reserve Asset");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter room number to reserve: ");
                    int roomIndex = scanner.nextInt();
                    if (roomIndex >= 1 && roomIndex <= rooms.length) {
                        Room room = rooms[roomIndex - 1];
                        if (!room.isReserved()) {
                            room.reserveRoom();
                            System.out.println("Room " + room.getRoomNumber() + " reserved successfully.");
                        } else {
                            System.out.println("Room " + room.getRoomNumber() + " is already reserved.");
                        }
                    } else {
                        System.out.println("Invalid room number.");
                    }
                    break;
                case 2:
                    System.out.print("Enter asset number to reserve: ");
                    int assetIndex = scanner.nextInt();
                    if (assetIndex >= 1 && assetIndex <= assets.length) {
                        Asset asset = assets[assetIndex - 1];
                        if (!asset.isReserved()) {
                            asset.reserveAsset();
                            System.out.println("Asset " + asset.getAssetName() + " reserved successfully.");
                        } else {
                            System.out.println("Asset " + asset.getAssetName() + " is already reserved.");
                        }
                    } else {
                        System.out.println("Invalid asset number.");
                    }
                    break;
                case 3:
                    System.out.print("Enter room/asset number to cancel reservation: ");
                    int cancelIndex = scanner.nextInt();
                    if (cancelIndex >= 1 && cancelIndex <= rooms.length) {
                        Room room = rooms[cancelIndex - 1];
                        if (room.isReserved()) {
                            room.cancelReservation();
                            System.out.println("Reservation for Room " + room.getRoomNumber() + " cancelled.");
                        } else {
                            System.out.println("Room " + room.getRoomNumber() + " is not reserved.");
                        }
                    } else if (cancelIndex >= rooms.length + 1 && cancelIndex <= rooms.length + assets.length) {
                        Asset asset = assets[cancelIndex - rooms.length - 1];
                        if (asset.isReserved()) {
                            asset.cancelReservation();
                            System.out.println("Reservation for Asset " + asset.getAssetName() + " cancelled.");
                        } else {
                            System.out.println("Asset " + asset.getAssetName() + " is not reserved.");
                        }
                    } else {
                        System.out.println("Invalid room/asset number.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
