package ParkingLot;////http://www.delbertbao.net/2011/12/06/object-oriented-design-part-1/
//
//package DesignPattern.ParkingLot;
//
//import java.util.Calendar;
//import java.util.GregorianCalendar;
//import java.util.List;
//
//interface Permission
//{
//    float getFee(Calendar start, Calendar end)
//    {
//
//    }
//}
//
//enum ParkingSpaceType
//    {
//        MOTORBIKE, CAR, HANDICAPPED;
//    }
//
//class ParkingLot{
//
//    private List <ParkingSpace> freeRegularSpace;
//    private List<ParkingSpace> freeHandicappedSpace;
//    private List<ParkingSpace> freeCompactSpace;
//
//    public ParkingLot()
//    {
//
//    }
//
//    public ParkingSpace allocateFreeSpace(ParkingSpace pspace)
//    {
//        //get a ParkingSpace from the corresponding free list
//        if(pspace==null)
//        {
//            System.out.println("NULL value");
//        }
//
//
//        //pspace.setStart();
//
//        return pspace;
//    }
//
//    public float reclaimFreeSpace(ParkingSpace pspace){
//
//        pspace.setEnd();
//
//        //return free space to the list
//        return pspace.getFee(perm);
//    }
//
//    private Permission perm;
//}
//
//class ParkingSpace
//{
//    private int id;
//    private ParkingSpaceType pspaceType;
//    private ParkingMeter meter;
//
//    public ParkingSpace(int id, ParkingSpaceType pspaceType)
//    {
//        super();
//        this.id = id;
//        this.pspaceType = pspaceType;
//    }
//
//    public int getId()
//    {
//        return id;
//    }
//
//    public ParkingSpaceType getpspaceType()
//    {
//        return pspaceType;
//    }
//
//    private class ParkingMeter{
//        public GregorianCalendar start;
//        public GregorianCalendar end;
//    }
//
//    public void setStart()
//    {
//        meter.start = new GregorianCalendar();
//    }
//    public void setEnd()
//    {
//        meter.end = new GregorianCalendar();
//    }
//
//    public float getFee(Permission perm)
//    {
//        return perm.getFee(meter.start, meter.end);
//    }
//}
//
// abstract class Vehicle
// {
//     private ParkingSpace pspace;
//
//    public boolean park(ParkingLot pLot)
//    {
//         if(pspace == null)
//         {
//             pspace=new ParkingSpace(id, ParkingSpaceType);
//             pLot.allocateFreeSpace(pspace);
//             return true;
//         }
//
//         return false;
//    }
//
//    public boolean unpark(ParkingLot pLot){
//        if(pspace != null){
//            pLot.reclaimFreeSpace(pspace);
//            return true;
//        }
//        return false;
//    }
//
//}
//
//
// class Motorbike extends Vehicle
// {
//
//    @Override
//    public boolean park(ParkingLot pLot)
//    {
//        if((pLot.allocateFreeSpace(ParkingSpaceType.MOTORBIKE))==null)
//        {
//            return false;
//        }
//        return true;
//    }
//}
//
// class Cars extends Vehicle
// {
//    @Override
//    public boolean park(ParkingLot pLot)
//    {
//        if((pLot.allocateFreeSpace(ParkingSpaceType.CAR))==null){
//            return false;
//        }
//        return true;
//    }
//}
//
//class HandicappedCars extends Vehicle
//{
//    public boolean park(ParkingLot pLot){
//        if((pLot.allocateFreeSpace(ParkingSpaceType.HANDICAPPED))==null && (pLot.getfreeSpace(ParkingSpaceType.CAR))==null){
//            return false;
//        }
//        return true;
//    }
//}
//public class parkinglot {
//
//}
