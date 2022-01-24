class RektangelHovedprogram {
    public static void main(String[] args) {
        Rektangel en = new Rektangel(3, 3);
        Rektangel to = new Rektangel(2, 9);

        System.out.println("Areal rektangel en: " + en.areal());
        System.out.println("Areal rektangel en: " + to.areal());

        en.oekLengde(2);
        to.oekBredde(3);

        System.out.println("Omkrets rektangel en: " + en.omkrets());
        System.out.println("Omkrets rektangel to: " + to.omkrets());
    }
}
